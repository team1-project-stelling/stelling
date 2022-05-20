package com.team1.stelling.controller;

import com.team1.stelling.domain.repository.UserRepository;
import com.team1.stelling.domain.vo.InquiryVO;
import com.team1.stelling.service.InquiryService;
import com.team1.stelling.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/inquiry/*")
public class InquiryController {

    private final UserService userService;
    private final InquiryService inquiryService;

    @GetMapping("/inquiryDetail")
    public String inquiryDetail (Model model) {
        /*        HttpSession session =  request.getSession(); */
//        inquiryService.get(Long.valueOf((Integer)session.getAttribute("userNumber"));
        InquiryVO inquiryVO = inquiryService.get(1L);
        model.addAttribute("inquiry", inquiryVO);
        return "inquiry/inquiryDetail";
    }

    @GetMapping("/inquiryWrite")
    public String writeInquiry(Model model) {

        /*        HttpSession session =  request.getSession();
        String userNickName = userService.findUserNickName(Long.valueOf((Integer)session.getAttribute("userNumber")));*/
        String userNickName = userService.findUserNickName(5L);
        model.addAttribute("userNickName", userNickName);
        return "inquiry/inquiryWrite";
    }
    @PostMapping("/inquiryWrite")
    public String inquiryRegister(InquiryVO inquiryVO, HttpServletResponse response) throws IOException {
        /*        HttpSession session =  request.getSession(); */


        log.info(inquiryVO.toString());
        response.setContentType("text/html; charset=euc-kr");

        PrintWriter out = response.getWriter();

//        inquiryVO.setUserVO(userService.get(Long.valueOf((Integer)session.getAttribute("userNumber")));
        inquiryVO.setUserVO(userService.get(5L));
        inquiryService.register(inquiryVO);


        out.println("<script>alert('뮨의가 등록 되었습니다.'); </script>");
        out.flush();
        return "/myPage/myPageQuestion";
    }


}
