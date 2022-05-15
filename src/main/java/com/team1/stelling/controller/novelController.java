package com.team1.stelling.controller;


import com.team1.stelling.aspect.annotation.LogStatus;
import com.team1.stelling.domain.repository.NovelFileRepository;
import com.team1.stelling.domain.repository.NovelRepository;
import com.team1.stelling.domain.vo.NovelVO;
import com.team1.stelling.service.NovelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
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
import java.util.*;

@Controller
@Slf4j
@RequestMapping("/novel/*")
@RequiredArgsConstructor
public class novelController {

    private final NovelRepository novelRepository;
    private final NovelFileRepository novelFileRepository;


    @GetMapping("/novelRegister")
    public void ViewDetail() {
    }

    @GetMapping("/novelWrite")
    public void novelWrite() {
    }

    @LogStatus
    @GetMapping("/novelCategory")
    public void novelCategory(Model model) {
    }

    @GetMapping("/novelRanking")
    public void novelRanking() {
    }

    @GetMapping("/novelRoundList")
    public void novelRoundList() {
    }

    @GetMapping("/novelDetailView")
    public void novelDetailView() {
    }

    @PostMapping("/novelRegister")
    public void novelRegister(NovelVO novelVO) {
        log.info("=============================================");
        log.info(novelVO.toString());
        log.info("=============================================");
        novelRepository.save(novelVO);

    }


    @PostMapping("/uploadAjaxAction")
    @ResponseBody
    public List<NovelVO> uploadAjaxPost(MultipartFile[] uploadFile) {
        String uploadFolder = "C:/stelling";
        List<NovelVO> fileList = new ArrayList<>();
//        UUID(Universally unique identifier) : 범용 고유 식별자
//        네트워크 상에서 각각의 개체들을 식별하기 위하여 사용되었다.
//        중복될 가능성이 거의 없다고 인정되기 때문에 많이 사용된다.
//        UUID의 개수는 10의 38승입니다.

        UUID uuid = UUID.randomUUID();
        String uploadFileName = null;

        String uploadFolderPath = getPath();
        File uploadPath = new File(uploadFolder, uploadFolderPath);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        for (MultipartFile file : uploadFile) {
            log.info("-------------------------");
            log.info("Upload File Name : " + file.getOriginalFilename());
            log.info("Upload File Size : " + file.getSize());

            NovelVO novelVO = new NovelVO();
            uploadFileName = uuid.toString() + "_" + file.getOriginalFilename();

            novelVO.setNovelFileName(uploadFileName);
            novelVO.setNovelUUID(uuid.toString());
            novelVO.setNovelUploadPath(uploadFolderPath);

            //저장할 경로와 파일의 이름을 File객체에 담는다.
            File saveFile = new File(uploadPath, uploadFileName);

            try {
                //설정한 경로에 해당 파일을 업로드한다.
                file.transferTo(saveFile);
//                InputStream in = new FileInputStream(saveFile);


                fileList.add(novelVO);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        log.info("----------------------------------------------------------");
        log.info(fileList.toString());
        log.info("----------------------------------------------------------");
        return fileList;
    }


    private String getPath() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date today = new Date();
        return sdf.format(today);
    }


    /*소설 회차 작성*/

    @ResponseBody
    @PostMapping(value = "/novelFileUpload", headers = ("content-type=multipart/*"))
    public String uploadTest(@RequestParam("file") MultipartFile mfile, Model model) throws IOException, TikaException, SAXException {
        log.info("========file들어옴======");

        String result = null;
        BodyContentHandler handler = new BodyContentHandler();
        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        InputStream fileStream = mfile.getInputStream();
        try (InputStream stream = fileStream) {
            parser.parse(stream, handler, metadata);
//        log.info(handler.toString());
            result = handler.toString();
        }


        return result;
    }


    @ResponseBody
    @PostMapping("/novelWriter")
//    @PostMapping(value = "/novelWriter", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public String novelBufferedWrite(String content, String subNovelTitle, Long novelNumber) throws IOException {
        Optional<NovelVO> novelVO = novelRepository.findById(novelNumber);
        String title = novelVO.get().getNovelTitle();
        log.info("-------------------------------------------------------------------------------------");
        log.info("novelWrite들어옴");
        log.info(content);
        log.info(subNovelTitle);
        log.info(title);
        log.info("-------------------------------------------------------------------------------------");




        String uploadFolder = "C:/stelling";
        UUID uuid = UUID.randomUUID();
        String uploadFolderPath = getPath()/*+ "노벨타이틀"*/;
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(uploadFolder + "/"+subNovelTitle)));
        bw.write(content);
        bw.close();
        return "파일생성 성공";
    }









}
