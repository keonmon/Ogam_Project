package com.go.ogamprj.controller.admin;

import com.go.ogamprj.dto.Member;
import com.go.ogamprj.sevice.AdminReplyService;
import com.go.ogamprj.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class Admin_ReplyController {

    @Autowired
    AdminReplyService adminReplyService;

    @Autowired
    MemberService memberService;

    /* USER 댓글 전체 가져오기 */
    @RequestMapping("/admin_replyList")
    public String replyList(HttpServletRequest request, String type, String keyword, Model model) {

        if ( keyword == null) {
            model.addAttribute("userReplyList", adminReplyService.userReplySelectAll());
        } else {
            model.addAttribute("userReplyList", adminReplyService.userReplySelectKeyword(type, "%"+ keyword + "%"));
        }

        return "admin/replyList";
    }

    /* 댓글 상세보기 */
    @RequestMapping("/commentPopup")
    public String commentPopup(HttpServletRequest request, Model model) {

        String member_email = "user1@ogam.com";
        HashMap<String, Object> user = memberService.findMember(member_email);

        model.addAttribute("member",user);

        return "admin/commentPopup";
    }


    /* 댓글 삭제 - 목록에서 삭제 */
    @RequestMapping("/deleteReply")
    public String deleteDiary(@RequestParam List<Integer> check) {

        if(check.size() > 0) {
            for(Integer num : check) adminReplyService.replyDelete(num);
        }

        return "redirect:/admin_replyList";
    }

    /* 댓글 삭제 - 팝업에서 삭제 */

}
