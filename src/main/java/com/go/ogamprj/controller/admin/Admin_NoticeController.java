package com.go.ogamprj.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Admin_NoticeController {

    @RequestMapping("/admin_noticeList")
    public String admin_noticeList() {

        return "admin/noticeList";
    }

    @RequestMapping("/writeNotice")
    public String writeNotice() {

        return "admin/board";
    }

    @RequestMapping("/addnotice")
    public String addnotice() {

        return "redirect:/admin_noticeList";
    }
}
