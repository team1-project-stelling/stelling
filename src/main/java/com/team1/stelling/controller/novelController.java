package com.team1.stelling.controller;


import com.team1.stelling.aspect.annotation.LogStatus;
import com.team1.stelling.domain.dto.NovelCategoryDTO;
import com.team1.stelling.domain.dto.PageDTO;
//import com.team1.stelling.domain.repository.NovelSearchRepository;
import com.team1.stelling.domain.vo.NovelVO;
import com.team1.stelling.service.IllustImgFileService;
import com.team1.stelling.service.NovelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/novel/*")
@RequiredArgsConstructor
public class novelController {

    private  final NovelService novelService;
//    private  final NovelSearchService novelSearchService;


    @GetMapping("/novelRegister")
    public void ViewDetail(){
    }

    @GetMapping("/novelWrite")
    public void novelWrite(){
    }

    @LogStatus
    @GetMapping("/novelCategory")
    public void novelCategory(Model model, @PageableDefault(page = 0, size = 10, sort = "novelNumber" ,direction = Sort.Direction.DESC)Pageable pageable){

       Page<NovelCategoryDTO> list = novelService.getList(pageable);
        PageDTO.PageableDTO pageableDTO = new PageDTO.PageableDTO( (int)list.getTotalElements(),pageable);
        model.addAttribute( "list",list);
        model.addAttribute( "novelTotal", list.getTotalElements());
        model.addAttribute("pageableDTO", pageableDTO);


    }

    @GetMapping("/novelRanking")
    public void novelRanking(){
    }

    @GetMapping("/novelRoundList")
    public void novelRoundList(){
    }

    @GetMapping("/novelDetailView")
    public void novelDetailView(){
    }

    @LogStatus
    @GetMapping("/novelSearch")
    public String novelSearch (String keyword, Model model, @PageableDefault(page = 0, size = 10, sort = "novelNumber" ,direction = Sort.Direction.DESC)Pageable pageable){
        log.info("#############keyword:"+keyword);
        Page<NovelCategoryDTO> searchList = novelService.search(keyword, pageable);
//        Page<NovelCategoryDTO> searchList = novelSearchService.search(keyword, pageable);
        PageDTO.PageableDTO pageableDTO = new PageDTO.PageableDTO( (int)searchList.getTotalElements(),pageable);
        searchList.getSize();
        model.addAttribute("list", searchList);
        model.addAttribute( "novelTotal", searchList.getTotalElements());
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageableDTO", pageableDTO);
        return "novel/novelCategory";
    }



}
