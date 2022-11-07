package com.go.ogamprj.controller.user;

import com.go.ogamprj.sevice.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class User_MyDiaryController {

    @Autowired
    DiaryService diaryService;


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
    public String writeDiary2(){
        return "user/userDiary/writeDiary2";
    }

    @RequestMapping("/writeDiary3")
    public String writeDiary3(){
        return "user/userDiary/writeDiary3";
    }

}
