package com.go.ogamprj.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Admin_UserController {


    @RequestMapping("/main1")
    public String main() {

        return "admin/main";
    }

    @RequestMapping("/reply")
    public String reply() {
        return "admin/replyList";
    }

}
