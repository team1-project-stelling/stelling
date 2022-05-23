package com.team1.stelling.controller;

import com.team1.stelling.domain.dto.PageDTO;
import com.team1.stelling.domain.vo.Criteria;
import com.team1.stelling.domain.vo.PayDTO;
import com.team1.stelling.domain.vo.PayVO;
import com.team1.stelling.domain.vo.SupportVO;
import com.team1.stelling.service.PayService;
import com.team1.stelling.service.SupportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
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
    public String payList(Long userNumber, Criteria criteria, Model model){
        NumberFormat numberFormat = NumberFormat.getInstance();
        String payChargeTotal = numberFormat.format(payService.getTotal(userNumber).getChargeTotal());
        log.info("총 결제 금액" + payChargeTotal);
        log.info(criteria.toString());

//        String startDate = criteria.getStartDate();
//        String endDate = criteria.getEndDate();
//        log.info("startDate : " + startDate);
//        log.info("endDate : " + endDate);

        model.addAttribute("payList", payService.getList(criteria, userNumber));
        model.addAttribute("payChargeTotal", payChargeTotal);
        model.addAttribute("pageDTO", new PageDTO(criteria, payService.getSearchTotal(criteria)));
        return "myPage/myPagePayList";
    }

    @GetMapping("/supportList")
    public String supportList(Long supportSponser, Criteria criteria, Model model){
        NumberFormat numberFormat = NumberFormat.getInstance();
        String supportCoinTotal = numberFormat.format(supportService.getSupportCoinTotal(supportSponser).getSupportTotal());
        log.info("총 후원 코인" + supportCoinTotal);

        model.addAttribute("supportList", supportService.getSupportList(criteria, supportSponser));
        model.addAttribute("supportCoinTotal", supportCoinTotal);
        model.addAttribute("pageDTO", new PageDTO(criteria, supportService.getSearchSupportTotal(criteria)));
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
