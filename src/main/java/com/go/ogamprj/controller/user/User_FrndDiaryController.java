package com.go.ogamprj.controller.user;

import com.go.ogamprj.sevice.FriendDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class User_FrndDiaryController {

    @Autowired
    FriendDiaryService friendDiaryService;

    // 친구 리스트 목록 가져오기
    @RequestMapping("/friendList")
    public String friendList(HttpServletRequest request, Model model) {

        String myEmail = "user1@ogam.com";

        // 친구 전체 리스트
        List<Map<String, Object>> friendList = friendDiaryService.friendListSelectAll(myEmail);

        // 친구리스트 카운트해서 가져오기
        int friendListCount = friendDiaryService.friendListCount(myEmail);

        model.addAttribute("friendListCount",friendListCount);
        model.addAttribute("friendList",friendList);
        return "user/noticePage/friendList";
    }

    // 친구 신청 가져오기
    @RequestMapping("/sendList")
    public String sendList(Model model){

        return "user/noticePage/sendList";
    }
}
