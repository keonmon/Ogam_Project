package com.go.ogamprj.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class User_OthersDiaryController {

    // diaryAll
    @RequestMapping("/diaryAll")
    public String diaryAll() {

        return "/user/userDiary/diaryAll";
    }

}
