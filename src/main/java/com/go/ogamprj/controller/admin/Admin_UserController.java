package com.go.ogamprj.controller.admin;

import com.go.ogamprj.sevice.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Admin_UserController {

    @Autowired
    AdminUserService adminUserService;

    /* USER 전체 가져오기 */
    @RequestMapping("/admin_userList")
    public String userList(HttpServletRequest request, Model model) {

        model.addAttribute("userList", adminUserService.userSelectAll());


        return "admin/userList";
    }


}
