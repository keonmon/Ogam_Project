package com.go.ogamprj.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Admin_BlackListController {

    @RequestMapping("/notifyList")
    public String notifyList() {

        return "admin/notifyList";
    }
}
