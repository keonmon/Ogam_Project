package com.go.ogamprj.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class User_DashboardController {

    @RequestMapping("/dashboard")
    public String dashboard(){
        return "user/userDashboard/userDashboard";
    }
}
