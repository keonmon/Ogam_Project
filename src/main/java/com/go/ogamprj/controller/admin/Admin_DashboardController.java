package com.go.ogamprj.controller.admin;

import com.go.ogamprj.mapper.DashboardMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.logging.Logger;

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

    @RequestMapping("/emojiChart")
    public void emojiChart(HttpServletRequest request, @RequestParam String name) {
        Gson json = new Gson();

        ArrayList<>
    }

}
