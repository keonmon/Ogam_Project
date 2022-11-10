package com.go.ogamprj.controller.user;

import com.go.ogamprj.dto.friendApply;
import com.go.ogamprj.sevice.FriendDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class User_FrndDiaryController {

    @Autowired
    FriendDiaryService friendDiaryService;

    // 친구 리스트 목록 가져오기
    @RequestMapping("/friendList")
    public String friendList(HttpServletRequest request,String searchKeyword, Model model) {

        String myEmail = "user1@ogam.com";

        if(searchKeyword == null) {
        // 친구 전체 리스트
        List<Map<String, Object>> friendList = friendDiaryService.friendListSelectAll(myEmail);

        model.addAttribute("friendList",friendList);
        } else {
        // 친구 검색 리스트
        List<Map<String, Object>> search = friendDiaryService.search(searchKeyword);

        model.addAttribute("friendList", search);

        }

        // 친구리스트 카운트해서 가져오기
        int friendListCount = friendDiaryService.friendListCount(myEmail);

        model.addAttribute("friendListCount",friendListCount);

        return "user/noticePage/friendList";
    }

    @RequestMapping("/deleteFriend")
    @ResponseBody
    public String deleteFriend(String nickname) {

        String myEmail = "user1@ogam.com";

        friendDiaryService.deleteFriend(myEmail, nickname);
        return "success";
    }

    // 친구 신청 가져오기
    @RequestMapping("/sendList")
    public String sendList(Model model){

        String myEmail = "user1@ogam.com";

        List<Map<String, Object>> friendSendList = friendDiaryService.friendSendSelectAll(myEmail);

        model.addAttribute("friendSendList",friendSendList);
        return "user/noticePage/sendList";
    }

    // 친구 수락/거절
    @RequestMapping("/response")
    @ResponseBody
    public String response(HttpServletRequest request, @RequestParam String member_op_email, String response, String nickname) {

        String myEmail = "user1@ogam.com";

        if(response.equals("y")) {
            friendDiaryService.insertfriendList(new friendApply(0,myEmail,member_op_email,null,0));
            //friendDiaryService.deleteFriendSend(myEmail);
        }
        return "success";
    }
}
