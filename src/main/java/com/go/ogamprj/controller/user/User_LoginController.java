package com.go.ogamprj.controller.user;

import com.go.ogamprj.sevice.KakaoAPIService;
import com.go.ogamprj.sevice.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class User_LoginController {

    @Autowired
    KakaoAPIService kakaoAPIService;
    @Autowired
    LoginService loginService;

    @RequestMapping("/loginPage")
    public String loginPage(@RequestParam(required = false, defaultValue = "") String member_email, Model model){
        model.addAttribute("member_email", member_email);
        return "user/loginPage/loginPage";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, @RequestParam String member_email, @RequestParam String member_pw){

       boolean loginvalid = loginService.loginvalid(member_email, member_pw);


      if(loginvalid == true) {

         return "user/userDashboard/userDashboard";
      } else{

       return "redirect:/loginPage";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session){
        request.getSession().removeAttribute("loginUser");
        Object accessToken = request.getSession().getAttribute("accessToken");

        // 카카오로 로그인 되어있다면?
        if(accessToken != null){
            kakaoAPIService.kakaoLogout((String)session.getAttribute("accessToken"));
            session.invalidate();
            request.getSession().removeAttribute("accessToken");
        }
        return "redirect:/";
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
