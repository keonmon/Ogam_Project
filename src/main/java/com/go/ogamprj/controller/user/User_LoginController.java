package com.go.ogamprj.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class User_LoginController {


    @RequestMapping("/loginPage")
    public String loginPage(){

        return "user/loginPage/loginPage";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request){

        return "redirect:/loginPage";

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


}
