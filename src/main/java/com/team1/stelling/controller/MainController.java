package com.team1.stelling.controller;

import com.team1.stelling.domain.dto.NewIllustDTO;
import com.team1.stelling.domain.dto.NovelDTO;
import com.team1.stelling.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/index")
    public void index(){}

    //임시로 작업중인 메서드, 위 컨트롤러에 쓸 예정
    @GetMapping("/showMain")
    public String showMain(Model model) {
            //소설 신작
            List<NovelDTO> newWorkList = mainService.getNewNovelList();
            log.info("********신작 리스트 : " + newWorkList.toString());
            model.addAttribute("newWorkList", newWorkList);

            //일러스트 신작
            List<NewIllustDTO> newIllustList = mainService.getNewIllustList();
            model.addAttribute("newIllustList", newIllustList);

        return "main/index";
    }

    @GetMapping("/display")
    public ResponseEntity<byte[]> getImage(String fileName){

    File file = new File("c:\\upload\\" + fileName);

    log.info("getImage()..........." + fileName);

    ResponseEntity<byte[]> result = null;

        try {
            HttpHeaders header = new HttpHeaders();
            header.add("Content-type", Files.probeContentType(file.toPath()));
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
