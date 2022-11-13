package com.go.ogamprj.controller.user;

import com.go.ogamprj.sevice.NotifiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class User_Notifi_Controller {

    @Autowired
    NotifiService notifiService;

    @RequestMapping("/notifi")
    @ResponseBody
    public String notifi(HttpServletRequest request, Model model) {

        String myEmail = (String)request.getSession().getAttribute("loginUser");

        // 알림 myEmail 유저한테 온거 select
        List<Map<String, Object>> notifiSelect = notifiService.notifiSelect();
        System.out.println(notifiSelect);
        return "frag/user/user_menubar :: .currentNotifi";
    }
}
