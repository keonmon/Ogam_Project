package com.go.ogamprj.controller.admin;

import com.go.ogamprj.sevice.AdminDiaryService;
import com.go.ogamprj.sevice.AdminUserService;
import com.go.ogamprj.sevice.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class Admin_DiaryController {

    @Autowired
    AdminDiaryService adminDiaryService;

    @Autowired
    DiaryService diaryService;


    /* USER 일기 전체 가져오기 */
    @RequestMapping("/admin_diaryList")
    public String diaryList(HttpServletRequest request, String type, String keyword, Model model) {

//        model.addAttribute("member",memberService.findMember(member_email));

        if ( keyword == null) {
            model.addAttribute("userDiaryList", adminDiaryService.userDiarySelectAll());
        } else {
            model.addAttribute("userDiaryList", adminDiaryService.userDiarySelectKeyword(type, "%"+ keyword + "%"));
        }

        return "admin/diaryList";
    }

    /* 일기 상세보기 */

    @RequestMapping("/diaryPopup/{diarySeq}")
    public String diaryPopup(@PathVariable String diary_seq, Model model) {
        System.out.println(diary_seq);
        diary_seq = "2";
        model.addAttribute("diary",diaryService.diarySelectOne(Integer.parseInt(diary_seq)));

        return "admin/diaryPopup";
    }

    @RequestMapping("/diaryPopup")
    public String diaryPopup(HttpServletRequest request, Model model) {

        int diary_seq = 107;

        Map<String, Object> diary = adminDiaryService.diarySelectOne(diary_seq);

        model.addAttribute("diary", diary);

        // 신고횟수
        model.addAttribute("count", adminDiaryService.diaryCount(diary_seq));

        return "admin/diaryPopup";
    }

    /* 일기 삭제 - 목록에서 삭제 */
    @RequestMapping("/deleteDiary")
    public String deleteDiary(@RequestParam List<Integer> check) {

        if(check.size() > 0) {
            for(Integer num : check) adminDiaryService.diaryDelete(num);
        }

        return "redirect:/admin_diaryList";
    }

    /* 일기 삭제 - 팝업에서 삭제 */
    @RequestMapping("/deleteDiaryPopup")
    public String deleteDiaryPopup(@RequestParam String diary_seq) {

        return "";
    }


}
