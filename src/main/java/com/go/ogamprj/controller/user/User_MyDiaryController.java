package com.go.ogamprj.controller.user;

import com.go.ogamprj.sevice.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class User_MyDiaryController {

    @Autowired
    DiaryService diaryService;

    @Value("${upload.path}")
    private String fileDir;

    @RequestMapping("/myDiary")  // http://localhost:8081/myDiary
    public String myDiary(HttpServletRequest request, Model model){

        // 로그인유저의 세션정보 가져오기 (이메일주소)
        String myEmail = (String)request.getSession().getAttribute("loginUser");

        // 내 일기 가져오기
        List<HashMap<String, Object>> myDiaryList = diaryService.oneDiarySelectAll(myEmail);

        // 친구 일기 가져오기
        List<HashMap<String, Object>> friendDiaryList = diaryService.friendDiarySelectAll(myEmail);

        model.addAttribute("myDiaryList", myDiaryList);
        model.addAttribute("friendDiaryList", friendDiaryList);

        return "user/userDiary/myDiary";
    }

    @RequestMapping(value="/getEmotion", method={RequestMethod.POST})
    public String getEmotion(@RequestParam Map<String,Object> emotion, Model model){
        //System.out.println(diaryService.getEmotions(emotion.get("emotion").toString()));
        model.addAttribute("emotions", diaryService.getEmotions(emotion.get("emotion").toString()));

        return "user/userDiary/writeDiary1 :: .emojiList";
    }

    @RequestMapping("/writeDiary1")
    public String writeDiary1(Model model){
        model.addAttribute("emotions", diaryService.getEmotions("기쁨"));
        return "user/userDiary/writeDiary1";
    }

    @RequestMapping("/writeDiary2")
    public String writeDiary2(HttpServletRequest request, Model model, @RequestParam int emotion_seq){
        request.getSession().setAttribute("writeEmotionSeq",emotion_seq);

        model.addAttribute("emoji", diaryService.getEmojiSelectOne(emotion_seq));
        return "user/userDiary/writeDiary2";
    }

    @RequestMapping("/writeDiary3")
    public String writeDiary3(HttpServletRequest request, Model model,
                              @RequestParam String contents,
                              @RequestParam(defaultValue = "n") String diary_private){
        request.getSession().setAttribute("writeContents",contents);
        //request.getSession().setAttribute("writePrivate",diary_private);


        int emotion_seq = (int)request.getSession().getAttribute("writeEmotionSeq");
        model.addAttribute("emoji", diaryService.getEmojiSelectOne(emotion_seq));
        model.addAttribute("writePrivate",diary_private);
        return "user/userDiary/writeDiary3";
    }

    @RequestMapping(value = "/insertDiary",method = RequestMethod.POST)
    public String insertDiary(HttpServletRequest request, Model model,
                              @RequestParam(defaultValue = "n") String diary_private,
                              @RequestParam MultipartFile file){
        request.getSession().setAttribute("writePrivate",diary_private);
        int writeEmotionSeq = (int)request.getSession().getAttribute("writeEmotionSeq");
        String writeContents = (String)request.getSession().getAttribute("writeContents");

        // 업로드된 파일 처리
            // 파일이 비어있을 경우 (js에서 먼저 valid하기때문에 여기에 걸릴 일은 거의 없음)
        if(file.isEmpty()) {
            int emotion_seq = (int)request.getSession().getAttribute("writeEmotionSeq");
            model.addAttribute("emoji", diaryService.getEmojiSelectOne(emotion_seq));
            model.addAttribute("writePrivate",diary_private);

            return "redirect:/writeDiary3";
        }

        // 서버 webapp 경로 추출
        String realPath = request.getSession().getServletContext().getRealPath("/");

        // file의 실제이름 추출
        String origName = file.getOriginalFilename();

        // 파일 이름으로 쓸 uuid 생성
        String uuid = UUID.randomUUID().toString();

        // 확장자 추출(ex : .png)
        String extension = origName.substring(origName.lastIndexOf("."));

        // uuid와 확장자 결합
        String savedName = uuid + extension;

        // 파일을 불러올 때 사용할 파일 경로
        String savedPath = realPath + fileDir + savedName;


        // 실제로 로컬에 uuid를 파일명으로 저장
        try {
            file.transferTo(new File(savedPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //int diarySeq = diaryService.

        //+diarySeq
        //return "user/userDiary/viewDiary?diarySeq=";
        return "";
    }

    @RequestMapping("/diaryAll")
    public String diaryAll(){
        return "user/userDiary/diaryAll";
    }

}
