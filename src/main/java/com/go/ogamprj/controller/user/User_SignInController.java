package com.go.ogamprj.controller.user;


import com.go.ogamprj.dto.Member;
import com.go.ogamprj.sevice.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class User_SignInController {

    @Autowired
    SignupService signupService;

    @RequestMapping("/SignUpForm")
    public  String SignUpForm(@RequestParam(required = false, defaultValue = "") String member_email){
        return "user/loginPage/SignUp";
    }

    @RequestMapping("/signup")
    public String signup(@RequestParam String member_email, String member_pw,
                         String member_nick, String birth1, String birth2, String birth3, String gender, String member_phone){

        Member member = signupService.insert(new Member(member_email, member_pw, member_nick, birth1+"/"+birth2+"/"+birth3, gender, member_phone));

        System.out.println(member);

        return "user/loginPage/loginPage";
    }
    // 닉네임 중복확인
    @RequestMapping("/findByNick")
    @ResponseBody
    public int unique(@RequestParam String member_nick) {

        int uniqueChk = signupService.uniqueChk(member_nick);

        return uniqueChk;
    }

}
