package com.team1.stelling.controller.illustController;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/illust/*")
public class illustController {

    @GetMapping("/illustList")
    public void illustList(){
    }
    @GetMapping("/chatForm")
    public void chatForm(){
    }
    @GetMapping("/header")
    public String header(){
        return "fix/header_word_illust";
    }
    @GetMapping("/illustCategoryList")
    public void illustCategoryList(){
    }
    @GetMapping("/illustPostingPage")
    public void PostingPage(){
    }
    @GetMapping("/illustratorWritePage")
    public void writePage(){
    }
    @GetMapping("/illustUserPage")
    public void userPage(){
    }
    @GetMapping("/illustViewDetail")
    public void ViewDetail(){
    }




    @GetMapping("/uploadTest")
    public String readFile() {
        return "upload/uploadTest";
    }


/*
    @PostMapping("/uploadTest")
    public String uploadTest(@RequestParam("file") MultipartFile mfile, Model model) throws IOException, TikaException, SAXException {
        log.info("========file들어옴======");
*/
/*        try{
            InputStream fileStream  =  mfile.getInputStream();

        //버퍼 선언
        byte[] readBuffer = new byte[fileStream.available()];
        while (fileStream.read( readBuffer ) != -1){}
        log.info(new String(readBuffer)); //출력

        fileStream.close(); //스트림 닫기
    } catch (Exception e) {
       log.info(e.getMessage());
    }*//*


        String result = null;
        BodyContentHandler handler = new BodyContentHandler();
        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        InputStream fileStream  =  mfile.getInputStream();
        try (InputStream stream = fileStream)
        {
        parser.parse(stream, handler, metadata);
//        log.info(handler.toString());
        result =handler.toString();
        }


        return result;
    }
*/



}
