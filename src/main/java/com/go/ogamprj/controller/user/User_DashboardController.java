package com.go.ogamprj.controller.user;

import com.go.ogamprj.sevice.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class User_DashboardController {

    @Autowired
    DiaryService diaryService;

    @RequestMapping("/")
    public String dashboard(HttpServletRequest request, Model model){

        // **임시** 작업중 임시로 무조건 user1으로 로그인된 상태
       //request.getSession().setAttribute("loginUser", "user1@ogam.com");


        // 현재 세션에 저장된 로그인유저의 이메일 주소 가져오기
        Object myEmail = request.getSession().getAttribute("loginUser");

        // 세션이 비어있지 않다면(로그인 상태)
        if(myEmail!=null){
            // 내 일기 가져오기
            List<HashMap<String, Object>> myDiaryList = diaryService.oneDiarySelectAll(myEmail.toString());

            // 친구 일기 가져오기
            List<HashMap<String, Object>> friendDiaryList = diaryService.friendDiarySelectAll(myEmail.toString());

            model.addAttribute("myDiaryList", myDiaryList);
            model.addAttribute("friendDiaryList", friendDiaryList);
        }

        // 모두의 일기 랜덤으로 가져오기 15개
        List<HashMap<String, Object>> randomAllDiaryList = diaryService.randomAllDiarySelectAll();

        model.addAttribute("randomAllDiaryList", randomAllDiaryList);

        return "user/userDashboard/userDashboard";
    }
}
