package com.go.ogamprj.controller.admin;

import com.go.ogamprj.dto.Member;
import com.go.ogamprj.sevice.AdminUserService;
import com.go.ogamprj.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class Admin_UserController {

    @Autowired
    AdminUserService adminUserService;

    @Autowired
    MemberService memberService;

    /* USER 전체 가져오기 */
    @RequestMapping("/admin_userList")
    public String userList(HttpServletRequest request, String type, String keyword, Model model) {

        if ( keyword == null) {
            model.addAttribute("userList", adminUserService.userSelectAll());
        } else {
            model.addAttribute("userList", adminUserService.userSelectKeyword(type, "%"+ keyword + "%"));
        }

        return "admin/userList";
    }

    /* 사용자 정보 상세보기 */
    @RequestMapping("/memberPopup")
    public String memberPopup(HttpServletRequest request, Model model) {

        String member_email = "user1@ogam.com";
        HashMap<String, Object> user = memberService.findMember(member_email);

        model.addAttribute("member",user);

        String[] birth = user.get("MEMBER_BIRTH").toString().split("/");
        model.addAttribute("year", birth[0]);
        model.addAttribute("month", birth[1]);
        model.addAttribute("day", birth[2]);

        return "admin/memberPopup";
    }

    /* 사용자 정보 수정 */
    @RequestMapping("/admin_userUpdate")
    public String userUpdate(HttpServletRequest request) {

        return "redirect:/memberPopup";
    }


}
