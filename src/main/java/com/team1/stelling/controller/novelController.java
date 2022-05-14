package com.team1.stelling.controller;


import com.team1.stelling.aspect.annotation.LogStatus;
import com.team1.stelling.domain.vo.NovelVO;
import com.team1.stelling.domain.vo.PageableDTO;
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

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/novel/*")
@RequiredArgsConstructor
public class novelController {

    private  final NovelService novelService;


    @GetMapping("/novelRegister")
    public void ViewDetail(){
    }
    @GetMapping("/novelWrite")
    public void novelWrite(){
    }
    @LogStatus
    @GetMapping("/novelCategory")
    public void novelCategory(Model model){
        log.info("########"+novelService.getTotal()+"개");
        model.addAttribute( "list",novelService.getList());
        model.addAttribute( "novelTotal",novelService.getTotal());
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
        Page<NovelVO> searchList = novelService.search(keyword, pageable);
/*        int pageCount = 10;
        int endPage = (int)(Math.ceil(pageable.getPageNumber() / 10.0)) * pageCount;
        int startPage =  endPage - pageCount + 1;
        int realEnd = (int)Math.ceil(novelService.getTotal() /(double) pageCount);
        if(endPage > realEnd){
            endPage = realEnd == 0 ? 1 :realEnd;
        }*/
//        int nowPage = searchList.getPageable().getPageNumber() + 1;
/*        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, searchList.getTotalPages());*/

//        PageableDTO pageableDTO = new PageableDTO(novelService.getTotal(),pageable);
        PageableDTO pageableDTO = new PageableDTO( (int)searchList.getTotalElements(),pageable);
        searchList.getSize();
        model.addAttribute("list", searchList);
        model.addAttribute( "novelTotal", searchList.getTotalElements());
//        model.addAttribute( "novelTotal",novelService.getTotal());
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageableDTO", pageableDTO);
/*        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);*/

/*        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasNext", searchList.hasNext());
        model.addAttribute("hasPrev", searchList.hasPrevious());
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("pageNumber", pageable.getPageNumber());*/





        log.info("#####################");
        log.info("pageNumber:"+pageable.getPageNumber());
        log.info("pageNumber:"+pageable.getPageNumber());
        log.info("getPageSize:"+pageable.getPageSize());
        log.info("realEnd:"+pageable.getPageSize());
/*        log.info("endPage:"+endPage);
        log.info("startPage:"+startPage);*/
        log.info("#####################");
        /*
        this.endPage = (int)(Math.ceil(criteria.getPageNum() / 10.0)) * pageCount;
           this.endPage = (int)(Math.ceil(criteria.getPageNum() / 10.0)) * pageCount;
        *  this.startPage = endPage - pageCount + 1;
        * */



        return "novel/novelCategory";
    }



}
