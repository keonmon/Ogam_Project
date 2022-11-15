package com.go.ogamprj.controller.admin;

import com.go.ogamprj.dto.Member;
import com.go.ogamprj.sevice.AdminReplyService;
import com.go.ogamprj.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
public class Admin_ReplyController {

    @Autowired
    AdminReplyService adminReplyService;

    public static void init(HttpServletResponse response) {
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
    }

    /* USER 댓글 전체 가져오기 */
    @RequestMapping("/admin_replyList")
    public String replyList(HttpServletRequest request, HttpServletResponse response,
                            String type, String keyword, Model model) throws IOException {

        init(response);
        PrintWriter out = response.getWriter();

        // ADMIN 로그인
        String admin_email = (String)request.getSession().getAttribute("admin_email");

        if(admin_email == null) {
            out.println("<script>alert('ADMIN계정으로 로그인해주세요'); location.href='/'</script>");
            out.flush();
        } else if (!admin_email.equals("admin@ogam.com")) {
            out.println("<script>alert('ADMIN계정으로 로그인해주세요'); location.href='/'</script>");
            out.flush();
        }

        if (keyword == null) {
            model.addAttribute("userReplyList", adminReplyService.userReplySelectAll());
        } else {
            model.addAttribute("userReplyList", adminReplyService.userReplySelectKeyword(type, "%" + keyword + "%"));
        }

        return "admin/replyList";

    }

    /* 댓글 상세보기 */
    @RequestMapping("/commentPopup")
    public String commentPopup(HttpServletRequest request,
                               @RequestParam int reply_seq, Model model) {

        Map<String, Object> reply = adminReplyService.replySelectOne(reply_seq);

        model.addAttribute("reply", reply);

        // 신고횟수
        model.addAttribute("count", adminReplyService.replyCount(reply_seq));

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
    @RequestMapping("/deleteReplyPopup")
    @ResponseBody
    public String deleteReplyPopup(HttpServletRequest request, @RequestParam int reply_seq) {

        adminReplyService.replyDelete(reply_seq);

        return "<script>window.opener.location.reload(); window.close();</script>";
    }

}
