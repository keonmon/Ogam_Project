package com.go.ogamprj.controller.admin;

import com.go.ogamprj.dto.Chart;
import com.go.ogamprj.dto.Diary;
import com.go.ogamprj.dto.Emotions;
import com.go.ogamprj.mapper.DashboardMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class Admin_DashboardController {
    @Autowired
    DashboardMapper dashboardMapper;

    @RequestMapping("/adminMain") // application root
    public String main(Model model) {
        model.addAttribute("users", dashboardMapper.users() + "명");
        model.addAttribute("removeUser", dashboardMapper.removeUser() + "명");
        model.addAttribute("diary", dashboardMapper.diary() + "개");
        model.addAttribute("reply", dashboardMapper.reply() + "개");

//        for(Chart eChart : arrChart) {
//            chart.setEmotion(eChart.getEmotion());
//            chart.setCount(eChart.getCount());
//        }
//        System.out.println(chart);

        return "admin/main";
    }



}
