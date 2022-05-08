package com.team1.stelling.controller.averyTest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/file/*")
public class FileTestController {


    @PostMapping(value = "/uploadTest", headers = ("content-type=multipart/*"))
    public String uploadTest(@RequestParam("file") MultipartFile mfile, Model model) throws IOException, TikaException, SAXException {
        log.info("========file들어옴======");
/*        try{
            InputStream fileStream  =  mfile.getInputStream();

        //버퍼 선언
        byte[] readBuffer = new byte[fileStream.available()];
        while (fileStream.read( readBuffer ) != -1){}
        log.info(new String(readBuffer)); //출력

        fileStream.close(); //스트림 닫기
    } catch (Exception e) {
       log.info(e.getMessage());
    }*/

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



}


