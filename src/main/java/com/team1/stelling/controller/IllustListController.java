package com.team1.stelling.controller;

import com.team1.stelling.aspect.annotation.LogStatus;
import com.team1.stelling.domain.vo.IllustVO;
import com.team1.stelling.service.IllustProfileService;
import com.team1.stelling.service.IllustService;
import com.team1.stelling.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/illust/*")
@RequiredArgsConstructor
public class IllustListController {
    private final IllustProfileService illustProfileService;
    private final IllustService illustService;
    private final UserService userService;

    @LogStatus
    @GetMapping("/getMyIllustList")
    public List<IllustVO> getMyIllustList(Long userNumber){
        List<IllustVO> myList = illustService.getList(1L);
        log.info("-----------------------------------------");
        log.info(myList.toString());
        log.info("-----------------------------------------");
        return myList;

    }
}
