package com.team1.stelling.service;

import com.team1.stelling.domain.criteria.NovelRankingCriteria;
import com.team1.stelling.domain.dao.NovelDAO;
import com.team1.stelling.domain.dto.NovelCategoryDTO;
import com.team1.stelling.domain.dto.NovelRankingDTO;
import com.team1.stelling.domain.repository.NovelRepository;
import com.team1.stelling.domain.vo.InquiryVO;
import com.team1.stelling.domain.vo.MyPickVO;
import com.team1.stelling.domain.vo.NovelVO;
import com.team1.stelling.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.Function;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;


import java.util.Date;
import java.util.List;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import java.util.stream.Collectors;
@Service
@Slf4j
@RequiredArgsConstructor
public class NovelService {
    private final NovelRepository novelRepository;

    private final NovelDAO novelDAO;

    private final ModelMapper modelMapper;

    static final int ENDNOVELSTAUTS = 2; // 완결 상태 값 2:

    public NovelVO get(Long nNO){ return novelRepository.findById(nNO).orElseGet(null);}

    public List<NovelVO> getList(){return novelRepository.findAll();}

    public void register(NovelVO novelVO){ novelRepository.save(novelVO);}

    public Long registerReturnNovelNum(NovelVO novelVO){ return novelRepository.save(novelVO).getNovelNumber();}

    public void modify(NovelVO novelVO) {
        novelVO.updateNovelUpdateDate();
        novelRepository.save(novelVO);
    }

    public int getTotal(){return novelRepository.findByIdTotal();}

    /*노벨 리스트 최신순으로가져오기*/

    /* search */
    @Transactional
    public Page<NovelCategoryDTO> search(String keyword, Pageable pageable) {
        return  novelRepository.findByNovelHashtagContaining(keyword,pageable).map(objectEntity -> modelMapper.map(objectEntity, NovelCategoryDTO.class));
    }

    /* 페이징처리 전체조회*/
    @Transactional
    public Page<NovelCategoryDTO> getList(Pageable pageable){
//        novelRepository.findAll(pageable).map(objectEntity -> modelMapper.map(objectEntity, NovelCategoryDTO.class));
        return  novelRepository.findAll(pageable).map(objectEntity -> modelMapper.map(objectEntity, NovelCategoryDTO.class));
    }
    /* 완결 소설 조회*/
    public Page<NovelCategoryDTO> getEndNovelList(Pageable pageable){
        return  novelRepository.findByNovelStatus(ENDNOVELSTAUTS, pageable).map(objectEntity -> modelMapper.map(objectEntity, NovelCategoryDTO.class));
    }
    public Page<NovelCategoryDTO> getEndNovelListSearch(String keyword,Pageable pageable){
        return novelRepository.findByNovelStatusAndNovelHashtagContaining(ENDNOVELSTAUTS,keyword,pageable).map(objectEntity -> modelMapper.map(objectEntity, NovelCategoryDTO.class));
    }

    /* 신작 조회 */
    public Page<NovelCategoryDTO> getNewNovelList(Date start, Date end,Pageable pageable ){
        return novelRepository.findAllByNovelUploadDateBetween(start,end,pageable).map(objectEntity -> modelMapper.map(objectEntity, NovelCategoryDTO.class));
    }
    /* 신작 검색*/
    public Page<NovelCategoryDTO> getNewNovelListSearch (Date start, Date end,String keyword,Pageable pageable ){
        return novelRepository.findAllByNovelUploadDateBetweenAndNovelHashtagContaining(start,end,keyword,pageable).map(objectEntity -> modelMapper.map(objectEntity, NovelCategoryDTO.class));
    }

    public List<NovelVO> getTop50 () {
        return novelRepository.findTop50ByOrderByNovelLikeCountTotalDesc();
    }

    public List<NovelRankingDTO> rankingSearch(NovelRankingCriteria novelRankingCriteria){
        return novelDAO.rankingSearch(novelRankingCriteria);
    }

    public Page<NovelVO> getPageList(Long userNumber, Pageable pageable){return novelRepository.findByUserVO_userNumber(userNumber, pageable);}

    public Page<NovelCategoryDTO> getListSearchAll(String keyword, Pageable pageable){
        return novelRepository.findByNovelHashtagContainingOrNovelTitleContainingOrUserVO_UserNickNameContaining(keyword,keyword,keyword,pageable).map(objectEntity -> modelMapper.map(objectEntity, NovelCategoryDTO.class));
    }
}