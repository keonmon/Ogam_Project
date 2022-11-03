package com.go.ogamprj.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Admin_NoticeController {

    @RequestMapping("/noticeList")
    public String noticeList() {

        return "admin/noticeList";
    }
}
