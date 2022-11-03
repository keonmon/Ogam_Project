package com.go.ogamprj.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Admin_UserController {

    @RequestMapping("/main")
    public String main() {

        return "admin/main";
    }
// 야이 이거 왜 안돼!!
    @RequestMapping("/reply")
    public String reply() {
        return "admin/replyList";
    }

}
