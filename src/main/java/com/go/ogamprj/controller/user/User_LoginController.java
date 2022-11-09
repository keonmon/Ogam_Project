package com.go.ogamprj.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class User_LoginController {

    @RequestMapping("/login")
    public String login(){

        return "/user/loginPage/login";
    }

    @RequestMapping("/Find")
    public String Find(){

        return "user/loginPage/Find";
    }

    @RequestMapping("/Find_id")
    public String findid(){

        return "user/loginPage/Find_id";
    }

    @RequestMapping("Find_pw")
    public String findpw(){

        return "user/loginPage/Find_pw";
    }

    @RequestMapping("/Signup")
    public  String signup(){

        return "user/loginPage/SignUp";
    }
}
