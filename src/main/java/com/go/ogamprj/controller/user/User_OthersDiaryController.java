package com.go.ogamprj.controller.user;

import com.go.ogamprj.sevice.User_OthersDiaryService;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class User_OthersDiaryController {

    @Autowired
    User_OthersDiaryService user_othersDiaryService;

    // diaryAll
    @RequestMapping("/diaryAll")
    public String diaryAll(HttpServletRequest request, Model model) {
        String myEmail = (String)request.getSession().getAttribute("loginUser");

        // 모두의 일기 가져오기
        List<Map<String, Object>> selectDiaryByMood =  user_othersDiaryService.selectDiaryAll();
        model.addAttribute("selectDiaryByMood",selectDiaryByMood);

        System.out.println(selectDiaryByMood);
        return "/user/userDiary/diaryAll";
    }

    // 기쁨 다이어리 select
    @RequestMapping(value = "/happyDiary", method = {RequestMethod.POST})
    public String happyDiary(@RequestBody String reqEmotion, Model model) throws  Exception {

        JSONObject jObject = new JSONObject(reqEmotion);
        String emotion = jObject.getString("reqEmotion");


        List<Map<String, Object>> selectDiaryByMood = user_othersDiaryService.selectDiaryByHappy(emotion);

        System.out.println(selectDiaryByMood);
        model.addAttribute("selectDiaryByMood",selectDiaryByMood);
        return "/user/userDiary/diaryAll :: .diaryContainer";
    }

}
