package com.go.ogamprj.controller.admin;

import com.go.ogamprj.mapper.AdminNotifyMapper;
import com.go.ogamprj.sevice.AdminNotifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class Admin_BlackListController {

    @Autowired
    AdminNotifyService adminNotifyService;
    @Autowired
    AdminNotifyMapper adminNotifyMapper;


    public static void init(HttpServletResponse response) {
        response.setContentType("text/html; charset=euc-kr");
        response.setCharacterEncoding("euc-kr");
    }

    /* 신고 기록 전체 가져오기 */
    @RequestMapping("/admin_notifyList")
    public String notifyList(HttpServletRequest request, HttpServletResponse response
                             , String type, String keyword, Model model) throws IOException {
        init(response);
        PrintWriter out = response.getWriter();

        // 어드민 로그인
        String admin_email = (String)request.getSession().getAttribute("admin_email");
        if(admin_email == null) {
            out.println("<script>alert('ADMIN계정으로 로그인해주세요'); location.href='/'</script>");
            out.flush();
        } else if (!admin_email.equals("admin@ogam.com")) {
            out.println("<script>alert('ADMIN계정으로 로그인해주세요'); location.href='/'</script>");
            out.flush();
        }

        if ( keyword == null) {
            model.addAttribute("notifyList", adminNotifyService.allBlackList());
        } else {
            model.addAttribute("notifyList", adminNotifyService.notifySelectKeyword(type, "%"+ keyword + "%"));
        }

        return "admin/notifyList";
    }


    /* 신고 삭제 - 목록에서 삭제 */
    @RequestMapping("/notifyDelete")
    public String deleteDiary(@RequestParam List<Integer> check, HttpServletRequest request) {
//        System.out.println(check); // [25]
//        System.out.println("1" + request.getParameter("" + check.get(0))); // 댓글, 일기
//        System.out.println("2" + request.getParameterNames().toString());
//        System.out.println("3" + request.getParameterMap().toString());

        String category = String.valueOf(request.getParameter("" + check.get(0)));

            for(int num : check) {
                if (category.equals("댓글")) {
                    System.out.println(category);
                    adminNotifyMapper.delBlackRely(num);
                } else if(category.equals("일기")) {
                    System.out.println(category);
                    adminNotifyMapper.delBlackDiary(num);
                }
            }

        return "redirect:/admin_notifyList";
    }




}
