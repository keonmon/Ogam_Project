package com.go.ogamprj.controller.admin;

import com.go.ogamprj.sevice.AdminDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class Admin_DiaryController {

    @Autowired
    AdminDiaryService adminDiaryService;


    /* USER 일기 전체 가져오기 */
    @RequestMapping("/admin_diaryList")
    public String diaryList(HttpServletRequest request, Model model) {

        model.addAttribute("userDiaryList", adminDiaryService.userDiarySelectAll());

        return "admin/diaryList";
    }

    @RequestMapping("/diaryPopup")
    public String diaryPopup() {

        return "diaryPopup";
    }







}
