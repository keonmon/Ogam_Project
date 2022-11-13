package com.go.ogamprj.controller.user;

import com.go.ogamprj.sevice.NotifiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class User_Notifi_Controller {

    @Autowired
    NotifiService notifiService;

    @RequestMapping("/notifi")
    @ResponseBody
    public String notifi() {

        //notifiService.selectMember();

        return "redirect";
    }
}
