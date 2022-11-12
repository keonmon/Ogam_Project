package com.go.ogamprj.controller.user;

import com.go.ogamprj.dto.friendApply;
import com.go.ogamprj.dto.friendSend;
import com.go.ogamprj.sevice.FriendDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

        String myEmail = (String)request.getSession().getAttribute("loginUser");

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

    // 친구 리스트 삭제
    @RequestMapping("/deleteFriend")
    @ResponseBody
    public String deleteFriend(HttpServletRequest request,String nickname) {

        String myEmail = (String)request.getSession().getAttribute("loginUser");

        friendDiaryService.deleteFriend(myEmail, nickname);
        return "success";
    }

    // 친구 신청 페이지
    @RequestMapping("/sendList")
    public String sendList(HttpServletRequest request, Model model){

        String myEmail = (String)request.getSession().getAttribute("loginUser");

        // 친구 신청 가져오기
        List<Map<String, Object>> friendSendList = friendDiaryService.friendSendSelectAll(myEmail);

        // member 전체 유저 가져오기
        List<Map<String, Object>> memberList = friendDiaryService.memberSelectAll(myEmail);
        System.out.println(memberList);
        model.addAttribute("memberList",memberList);
        model.addAttribute("friendSendList",friendSendList);
        return "user/noticePage/sendList";
    }

    // 모달 친구신청
    @RequestMapping("/addSendList")
    @ResponseBody
    public String addSendList(HttpServletRequest request, @RequestParam String member_email, @RequestParam String response) {

        String myEmail = (String)request.getSession().getAttribute("loginUser");

        friendDiaryService.insertfriendSend(new friendSend(0,myEmail,member_email,response,null));

        return "success";
    }

    // modal member 검색하기
    @RequestMapping(value = "modalSearch", method = {RequestMethod.POST})
    public String modalSearch(@RequestParam String searchKeyword, Model model) {

        List<Map<String, Object>> memberSearch = friendDiaryService.memberSearch(searchKeyword);

        System.out.println(memberSearch);

        model.addAttribute("memberList",memberSearch);
        return "user/noticePage/sendList :: .modalBody";
    }

    // 친구 수락/거절
    @RequestMapping("/response")
    @ResponseBody
    public String response(HttpServletRequest request, @RequestParam String member_op_email, String response, Integer fri_send_seq) {

        String myEmail = (String)request.getSession().getAttribute("loginUser");

        if(response.equals("y")) {
            friendDiaryService.insertfriendList(new friendApply(0,myEmail,member_op_email,null,0));
            friendDiaryService.deleteFriendSend(fri_send_seq);
        } else {
            friendDiaryService.deleteFriendSend(fri_send_seq);
        }
        return "success";
    }
}
