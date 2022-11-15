package com.go.ogamprj.controller.admin;

import com.go.ogamprj.mapper.AdminNotifyMapper;
import com.go.ogamprj.sevice.AdminNotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class Admin_BlackListController {

    @Autowired
    AdminNotifyService adminNotifyService;
    @Autowired
    AdminNotifyMapper adminNotifyMapper;

    /* 신고 기록 전체 가져오기 */
    @RequestMapping("/admin_notifyList")
    public String notifyList(HttpServletRequest request, String type, String keyword, Model model) {

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
//        System.out.println(cagetofry);

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
