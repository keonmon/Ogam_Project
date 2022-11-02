package com.go.ogamprj.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class User_MyDiaryController {

    @RequestMapping("/myDiary")
    public String myDiary(){
        return "user/userDiary/myDiary";
    }

    @RequestMapping("/writeDiary1")
    public String writeDiary1(){
        return "user/userDiary/writeDiary1";
    }

    @RequestMapping("/writeDiary2")
    public String writeDiary2(){
        return "user/userDiary/writeDiary2";
    }

    @RequestMapping("/writeDiary3")
    public String writeDiary3(){
        return "user/userDiary/writeDiary3";
    }

}
