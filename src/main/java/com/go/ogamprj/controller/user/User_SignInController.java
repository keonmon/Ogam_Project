package com.go.ogamprj.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class User_SignInController {

    @RequestMapping("/Signup")
    public  String signup(){

        return "user/loginPage/SignUp";
    }
}
