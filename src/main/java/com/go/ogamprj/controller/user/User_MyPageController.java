package com.go.ogamprj.controller.user;

import com.go.ogamprj.mapper.MemberMapper;
import com.go.ogamprj.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class User_MyPageController {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberMapper memberMapper;

    @RequestMapping("/MyPage")
    public String MyPage(HttpServletRequest request, Model model) {
//        String member_email = (String) request.getSession().getAttribute("member_email");
        String member_email = "user1@ogam.com";
        model.addAttribute("member", memberService.findMember(member_email));
        return "user/myPage/reviseInfo";
    }

    @RequestMapping("/reviseInfo")
    public String reviseInfo() {

        return "redirect:/MyPage";
    }

    @RequestMapping("/uniqueChk")
    public void uniqueChk(@RequestParam String member_nick) {
        memberMapper.uniqueChk(member_nick);
    }

}
