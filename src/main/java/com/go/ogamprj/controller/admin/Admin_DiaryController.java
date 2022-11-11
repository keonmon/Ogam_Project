package com.go.ogamprj.controller.admin;

import com.go.ogamprj.dto.Diary;
import com.go.ogamprj.sevice.AdminDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class Admin_DiaryController {


    @Autowired
    AdminDiaryService adminDiaryService;


    /* USER 일기 전체 가져오기 */
    @RequestMapping("/admin_diaryList")
    public String diaryList(HttpServletRequest request, String type, String keyword, Model model) {

        if ( keyword == null) {
            model.addAttribute("userDiaryList", adminDiaryService.userDiarySelectAll());
        } else {
            model.addAttribute("userDiaryList", adminDiaryService.userDiarySelectKeyword(type, "%"+ keyword + "%"));
        }

        return "admin/diaryList";
    }

    /* 일기 상세보기 */
    @RequestMapping("/diaryPopup")
    public String diaryPopup() {

        return "admin/diaryPopup";
    }


}
