package com.team1.stelling.controller;

import com.team1.stelling.domain.dto.PageDTO;
import com.team1.stelling.domain.vo.Criteria;
import com.team1.stelling.domain.vo.PayVO;
import com.team1.stelling.service.PayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/myLibrary/*")
@RequiredArgsConstructor
public class MyLibraryController {

    private final PayService payService;

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
            List<PayVO> pay = payService.getPayCharge(userNumber);
            List<PayVO> payList = payService.getList(criteria, userNumber);
//            DecimalFormat decFormat = new DecimalFormat("###,###");
//            List<String> tempCharge = new ArrayList<>();
//
//                for(int i = 0; i < payList.size(); i++){
//                    tempCharge.add(decFormat.format(pay.get(i).getPayCharge()));
//                    payList.get(i).setPayCharge(tempCharge.get(i));
//                }

//            List<Long> tempList = new ArrayList<Long>();
//            List<String> payChargeList = new ArrayList<String>();

//            for(int i=0; i<payList.size(); i++){
//                tempList.add(payList.get(i).getPayCharge());
//                payChargeList.add(decFormat.format(tempList.get(i)));
//            }
//
//
//
//            log.info("결제금액리스트 : " + payChargeList);

            model.addAttribute("payList", payList);
//            model.addAttribute("payChargeList", payChargeList);
            model.addAttribute("pageDTO", new PageDTO(criteria, payService.getSearchTotal(criteria)));
            model.addAttribute("payDTO", payService.getTotal(userNumber));
            return "myPage/myPagePayList";
    }

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
