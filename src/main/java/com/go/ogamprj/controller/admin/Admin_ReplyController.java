package com.go.ogamprj.controller.admin;

import com.go.ogamprj.sevice.AdminReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Admin_ReplyController {

    @Autowired
    AdminReplyService adminReplyService;

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
    public String commentPopup() {

        return "admin/commentPopup";
    }

}
