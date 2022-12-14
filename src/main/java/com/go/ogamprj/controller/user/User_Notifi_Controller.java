package com.go.ogamprj.controller.user;

import com.go.ogamprj.sevice.NotifiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Controller
public class User_Notifi_Controller {

    @Autowired
    NotifiService notifiService;

    @RequestMapping(value = "notifi", method = {RequestMethod.POST})
    public String notifi(HttpServletRequest request, Model model) throws Exception {

        String myEmail = (String)request.getSession().getAttribute("loginUser");

        // 알림 myEmail 유저한테 친구 신청 온거 select
        List<Map<String, Object>> notifiSelect = notifiService.notifiSelect(myEmail);
        System.out.println(notifiSelect);

        model.addAttribute("notifiSelectList",notifiSelect);
        return "frag/user/user_menubar :: .currentNotifi";
    }

    @RequestMapping(value = "deleteNotifi")
    @ResponseBody
    public String deleteNotifi(HttpServletRequest request,@RequestParam int noti_seq, Model model) {

        System.out.println(noti_seq);
        // 알림 읽으면 삭제
        notifiService.deleteNotifi(noti_seq);

        return "success";
    }
}
