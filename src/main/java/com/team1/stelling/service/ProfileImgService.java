package com.team1.stelling.service;

import com.team1.stelling.domain.repository.ProfileImgFileRepository;
import com.team1.stelling.domain.vo.ProfileImgFileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileImgService {
    private final ProfileImgFileRepository profileImgFileRepository;

    public void register(ProfileImgFileVO vo) {profileImgFileRepository.save(vo);}
    public ProfileImgFileVO get(Long pfifNo){return profileImgFileRepository.findById(pfifNo).get();}
    public List<ProfileImgFileVO> getList(){return profileImgFileRepository.findAll();}
    public void modify(ProfileImgFileVO vo){
        vo.updateProfileImgFileUpdateDate();
        profileImgFileRepository.save(vo);
    }

}
