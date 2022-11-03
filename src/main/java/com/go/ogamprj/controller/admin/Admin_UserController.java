package com.go.ogamprj.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Admin_UserController {

    @RequestMapping("/userList")
    public String userList() {

        return "admin/userList";
    }


}
