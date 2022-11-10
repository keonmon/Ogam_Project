package com.go.ogamprj.controller.admin;

import com.go.ogamprj.sevice.AdminNotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Admin_BlackListController {

    @Autowired
    AdminNotifyService adminNotifyService;

    /* 신고 기록 전체 가져오기 */
    @RequestMapping("/admin_notifyList")
    public String notifyList(Model model) {

        model.addAttribute("notifyList", adminNotifyService.notifySelectAll());

        return "admin/notifyList";
    }
}
