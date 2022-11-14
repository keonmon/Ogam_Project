package com.go.ogamprj.controller.admin;

import com.go.ogamprj.dto.Member;
import com.go.ogamprj.sevice.AdminUserService;
import com.go.ogamprj.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            List<Member> members =  adminUserService.userSelectAll();
            System.out.println(members);
            model.addAttribute("userList", members);
        } else {
            model.addAttribute("userList", adminUserService.userSelectKeyword(type, "%"+ keyword + "%"));
        }

        return "admin/userList";
    }

    /* 사용자 상세 정보 */
    @RequestMapping("/memberPopup")
    public String memberPopup(HttpServletRequest request, Model model) {

        String member_email = "user5@ogam.com";

        Map<String, Object> member = adminUserService.userSelectOne(member_email);

        model.addAttribute("member", member);

        // 생년월일
        String[] birth = member.get("MEMBER_BIRTH").toString().split("/");
        model.addAttribute("year", birth[0]);
        model.addAttribute("month", birth[1]);
        model.addAttribute("day", birth[2]);

        int count = adminUserService.diaryCount(member_email) + adminUserService.replyCount(member_email);
        model.addAttribute("count",count);

        return "admin/memberPopup";

    }

    /* 사용자 정보 수정 */
    @RequestMapping("/admin_userUpdate")
    public String userUpdate(HttpServletRequest request,
                             @RequestParam String member_blackYn, @RequestParam String member_black_reason) {

        String member_email = "user5@ogam.com";

        Member member = new Member(member_blackYn, member_black_reason);

        member.setMEMBER_EMAIL(member_email);

        adminUserService.userUpdate(member);

        return "redirect:/memberPopup";
    }


}
