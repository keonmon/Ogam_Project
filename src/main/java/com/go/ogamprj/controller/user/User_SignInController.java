package com.go.ogamprj.controller.user;


import com.go.ogamprj.dto.Member;
import com.go.ogamprj.sevice.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@Controller
public class User_SignInController {

    @Autowired
    SignupService signupService;

    public static void init(HttpServletResponse response) {
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
    }

    @RequestMapping("/SignUpForm")
    public  String SignUpForm(Model model){
        Member member = new Member("","","","","","");
        model.addAttribute("member",member);
        return "user/loginPage/SignUp";
    }


    @RequestMapping("/signup")

    public String signup(@RequestParam String member_email, String email_checked, String member_pw, String member_repw,
                         String member_nick, String nick_checked, String birth1, String birth2, String birth3, String gender, String member_phone,
                         Model model, HttpServletResponse response) throws IOException {
        Member member = new Member(member_email, member_pw, member_nick, birth1+"/"+birth2+"/"+birth3, gender, member_phone);
        init(response);
        PrintWriter out = response.getWriter();


        model.addAttribute("year","birth1");
        model.addAttribute("month","birth2");
        model.addAttribute("day","birth3");

        if(!member.getMEMBER_EMAIL().equals(email_checked)){
            // 이메일 중복확인 안함
            model.addAttribute("member",member);
            model.addAttribute("emailUnmatch","이메일 중복확인이 필요합니다");
            return "redirect:/SignUpForm";

            //비밀번호 불일치 처리
        } else if(!member.getMEMBER_PW().equals(member_repw)){
            model.addAttribute("member",member);
            model.addAttribute("pwdUnmatch","비밀번호가 일치하지 않아요");
            return "redirect:/SignUpForm";


            // 닉네임 중복확인 안함
        } else if(!member.getMEMBER_NICK().equals(nick_checked)){
            model.addAttribute("member",member);
            model.addAttribute("nickUnmatch","닉네임 중복확인이 필요합니다");
            return "redirect:/SignUpForm";
        }

        signupService.insert(member);

        out.println("<script>alert('회원가입이 완료되었습니다.'); location.href='/'</script>");
        out.flush();

        return "user/loginPage/loginPage";
    }

    // 이메일 중복확인
    @RequestMapping("/findByEmail")
    @ResponseBody
    public int uniquemail(@RequestParam String member_email) {

        int uniquEmail = signupService.uniqueEmail(member_email);

        return uniquEmail;
    }

    // 닉네임 중복확인
    @RequestMapping("/findByNick")
    @ResponseBody
    public int unique(@RequestParam String member_nick) {

        out.println(member_nick);

        int uniqueChk = signupService.uniqueChk(member_nick);

        return uniqueChk;
    }

}
