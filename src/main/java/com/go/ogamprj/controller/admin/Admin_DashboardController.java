package com.go.ogamprj.controller.admin;

import com.go.ogamprj.mapper.DashboardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Admin_DashboardController {
    @Autowired
    DashboardMapper dashboardMapper;

    @RequestMapping("/adminMain")
    public String main(Model model) {
        model.addAttribute("users", dashboardMapper.users() + "명");
        model.addAttribute("removeUser", dashboardMapper.removeUser() + "명");
        model.addAttribute("diary", dashboardMapper.diary() + "개");
        model.addAttribute("reply", dashboardMapper.reply() + "개");
        return "admin/main";
    }

    @RequestMapping("/diaryChart")
    public String chart() {
        return "admin/chart/diaryChart";
    }

}
