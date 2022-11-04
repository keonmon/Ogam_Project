package com.go.ogamprj.controller.user;

import com.go.ogamprj.sevice.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class User_DashboardController {

    @Autowired
    DiaryService diaryService;

    @RequestMapping("/")
    public String dashboard(){

        return "user/userDashboard/userDashboard";
    }
}
