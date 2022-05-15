package com.team1.stelling.controller;

import com.team1.stelling.aspect.annotation.LogStatus;
import com.team1.stelling.domain.dto.PageDTO;
import com.team1.stelling.domain.vo.NovelVO;
import com.team1.stelling.domain.dto.NovelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/novelSearch/*")
public class NovelSearchController {
    private final NovelService novelService;
    @LogStatus
    @GetMapping("/tagSearch")
    public String novelSearch (String keyword, Model model, @PageableDefault(page = 0, size = 10, sort = "novelNumber" ,direction = Sort.Direction.DESC) Pageable pageable){
        log.info("#############keyword:"+keyword);
        Page<NovelVO> searchList = novelService.search(keyword, pageable);

        PageDTO.PageableDTO pageableDTO = new PageDTO.PageableDTO( (int)searchList.getTotalElements(),pageable);
        model.addAttribute("list", searchList);
        model.addAttribute( "novelTotal", searchList.getTotalElements());
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageableDTO", pageableDTO);



        return "novel/novelCategory";
    }

}
