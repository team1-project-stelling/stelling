package com.team1.stelling.controller;

import com.team1.stelling.domain.dto.PageableDTO;
import com.team1.stelling.domain.vo.MyPickVO;
import com.team1.stelling.domain.vo.RecentViewVO;
import com.team1.stelling.service.MyLibraryService;
import com.team1.stelling.service.RecentViewService;
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
@RequestMapping("/myLibrary/myLibraryCollection/*")
@RequiredArgsConstructor
public class MyLibraryCollectionController {
    private final MyLibraryService myLibraryService;
    private final RecentViewService recentViewService;

    @GetMapping("/myPick")
    public String myLibraryCollectionMyPick(Model model, @PageableDefault(page = 0, size = 10, sort = "myPickNumber" ,direction = Sort.Direction.DESC) Pageable pageable){

        // 로그인시 세션에 존재할 임시 유저 정보
        Long userNum = 1L;
        Page<MyPickVO> list = myLibraryService.getMyPickList(userNum,pageable);
        PageableDTO pageableDTO = new PageableDTO( (int)list.getTotalElements(),pageable);
        model.addAttribute("list",list);
        model.addAttribute("total",list.getTotalElements());
        model.addAttribute("pageableDTO", pageableDTO);
        return "myLibrary/myLibraryCollection";
    }

    @GetMapping("/myPick/search")
    public String myLibraryCollectionMyPickSearch(String keyword,Model model, @PageableDefault(page = 0, size = 10, sort = "myPickNumber" ,direction = Sort.Direction.DESC) Pageable pageable){

        // 로그인시 세션에 존재할 임시 유저 정보
        Long userNum = 1L;
        Page<MyPickVO> searchList = myLibraryService.getMyPickTagSearch(userNum,keyword,pageable);
        PageableDTO  pageableDTO = new PageableDTO( (int)searchList.getTotalElements(),pageable);
        pageableDTO.setKeyword(keyword);
        model.addAttribute("list",searchList);
        model.addAttribute("total",searchList.getTotalElements());
        model.addAttribute("pageableDTO", pageableDTO);
        return "myLibrary/myLibraryCollectionSearch";
    }

    @GetMapping("/myRecentView")
    public String myRecentView(Model model, @PageableDefault(page = 0, size = 10, sort = "recentViewNumber" ,direction = Sort.Direction.DESC) Pageable pageable){
        // 로그인시 세션에 존재할 임시 유저 정보
        Long userNum = 1L;
        Page<RecentViewVO> list = recentViewService.getMyView(userNum,pageable);
        PageableDTO  pageableDTO = new PageableDTO( (int)list.getTotalElements(),pageable);
        model.addAttribute("list",list);
        model.addAttribute("total",list.getTotalElements());
        model.addAttribute("pageableDTO", pageableDTO);
        return "myLibrary/myLibraryRecentView";
    }
}
