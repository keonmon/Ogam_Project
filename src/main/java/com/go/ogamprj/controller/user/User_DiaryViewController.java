package com.go.ogamprj.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class User_DiaryViewController {
    /**
     * 신고, 좋아요, 댓글기능 포함
     */

    @RequestMapping("/viewDiary")
    public String DiaryView(){
        return "user/userDiary/viewDiary";
    }

}
