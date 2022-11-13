package com.go.ogamprj.controller.admin;

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

    /* 신고 기록 전체 가져오기 */
    @RequestMapping("/admin_notifyList")
    public String notifyList(HttpServletRequest request, String type, String keyword, Model model) {

        if ( keyword == null) {
            model.addAttribute("notifyList", adminNotifyService.notifySelectAll());
        } else {
            model.addAttribute("notifyList", adminNotifyService.notifySelectKeyword(type, "%"+ keyword + "%"));
        }

        return "admin/notifyList";
    }

    /* 신고 삭제 - 목록에서 삭제 */
    @RequestMapping("/deleteNotify")
    public String deleteDiary(@RequestParam List<Integer> check) {

        if(check.size() > 0) {
            for(Integer num : check) adminNotifyService.notifyDelete(num);
        }

        return "redirect:/admin_notifyList";
    }


}
