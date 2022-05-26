package com.team1.stelling.controller;

import com.team1.stelling.domain.dto.PageableDTO;
import com.team1.stelling.domain.dto.PagingDTO;
import com.team1.stelling.domain.vo.*;
import com.team1.stelling.mapper.PayMapper;
import com.team1.stelling.service.PayService;
import com.team1.stelling.service.SupportService;
import com.team1.stelling.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/myLibrary/*")
@RequiredArgsConstructor
public class MyLibraryController {

    private final PayService payService;
    private final SupportService supportService;
    private final UserService userService;


    @RequestMapping("")
    public void myLibrary(){
        log.info("libaray");
    }

    // 소장함 -> 결제
    @GetMapping("/myLibraryCollection")
    public String myBook(){
        log.info("myLibraryCollection");
        return "myLibrary/myLibraryCollection";
    }

    // 최근 본 작품
    @GetMapping("/myLibraryRecentView")
    public String myLibraryRecentView(){
        log.info("myLibraryRecentView");
        return "myLibrary/myLibraryRecentView";
    }
    
    // 찜목록 -> 그냥찜
    @GetMapping("/myLibraryPick")
    public String myLibraryPick(){
        log.info("myLibraryPick");
        return "myLibrary/myLibraryPick";
    }

    @GetMapping("/coinShop")
    public String coinShop(){
        log.info("coinShop");
        return "cash/coinShop";
    }

    //결제 내역 등록
    @PostMapping("/coinShop")
    public String register(PayVO payVO){
        payService.register(payVO);
        return "cash/coinShop";
    }

    //결제 리스트(마이페이지)
    @GetMapping("/payList")
    public String payList(Long userNumber, Paging paging, Model model){
        log.info("유저 번호" + String.valueOf(userNumber));
        NumberFormat numberFormat = NumberFormat.getInstance();
        String payChargeTotal = numberFormat.format(payService.getTotal(userNumber).getChargeTotal());
        log.info("총 결제 금액" + payChargeTotal);
        log.info(paging.toString());

        int total = payService.getSearchTotal(paging);

        PagingDTO pageMaker = new PagingDTO(paging, total);

//        String startDate = criteria.getStartDate();
//        String endDate = criteria.getEndDate();
//        log.info("startDate : " + startDate);
//        log.info("endDate : " + endDate);
        model.addAttribute("payList", payService.getList(paging, userNumber));
        model.addAttribute("pageMaker", pageMaker);
        model.addAttribute("payChargeTotal", payChargeTotal);
//        model.addAttribute("pageDTO", new PageDTO(paging, payService.getSearchTotal(paging)));
        return "myPage/myPagePayList";
    }

    @GetMapping("/supportList")
    public String supportList(Long supportSponser, Paging paging, Model model){
        NumberFormat numberFormat = NumberFormat.getInstance();
        String supportCoinTotal = numberFormat.format(supportService.getSupportCoinTotal(supportSponser).getSupportTotal());
        log.info("총 후원 코인" + supportCoinTotal);

        int total = supportService.getSearchSupportTotal(paging);

        PagingDTO pageMaker = new PagingDTO(paging, total);

        model.addAttribute("supportList", supportService.getSupportList(paging, supportSponser));
        model.addAttribute("pageMaker", pageMaker);
        model.addAttribute("supportCoinTotal", supportCoinTotal);
//        model.addAttribute("pageDTO", new PageDTO(criteria, supportService.getSearchSupportTotal(criteria)));
        return "myPage/myPageSupportList";
    }

    //후원 리스트(마이페이지)
//    @GetMapping("/showList")
//    public String showList(Long userNumber, Criteria criteria, Model model){
//
//    }

//    @GetMapping("/payList/{userNumber}")
//    public String payList(@PathVariable Long userNumber, String startDate, String endDate, Model model){
//        if(startDate == null & endDate == null) {
//            model.addAttribute("payList", payService.getList(userNumber));
//        }
//        return "myPage/myPagePayList";
//    }
    //날짜 검색(마이페이지)
//    @GetMapping("/dateSelect")
//    public void dateSelect(String startDate, String endDate)
    //결제 내역 등록
//    @PostMapping("/register/{userNumber}/{payCharge}/{payCoinCount}")
//    public String register(@PathVariable Long userNumber, @PathVariable Long payCharge, @PathVariable Long payCoinCount){
//        payService.register(userNumber, payCharge, payCoinCount);
//        return "cash/coinShop";
//    }

}
