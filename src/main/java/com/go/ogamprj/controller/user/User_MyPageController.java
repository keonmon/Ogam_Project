package com.go.ogamprj.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class User_MyPageController {

    @RequestMapping("/MyPage")
    public String MyPage() {

        return "user/myPage/reviseInfo";
    }

    @RequestMapping("/reviseInfo")
    public String reviseInfo() {

        return "redirect:/MyPage";
    }


}
