package com.go.ogamprj.controller.user;

import com.go.ogamprj.dto.FriendApply;
import com.go.ogamprj.dto.FriendSend;
import com.go.ogamprj.dto.Notifi;
import com.go.ogamprj.sevice.DiaryService;
import com.go.ogamprj.sevice.FriendDiaryService;
import com.go.ogamprj.sevice.NotifiService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class User_FrndDiaryController {

    @Autowired
    FriendDiaryService friendDiaryService;
    
    @Autowired
    DiaryService diaryService;

    @Autowired
    NotifiService notifiService;

    // 친구 리스트 목록 가져오기
    @RequestMapping("/friendList")
    public String friendList(HttpServletRequest request,String searchKeyword, Model model) {

        String myEmail = (String)request.getSession().getAttribute("loginUser");

        if(myEmail == null){
            return "redirect:/";
        } else {
            if(searchKeyword == null) {

            // 친구 전체 리스트
            List<Map<String, Object>> friendList = friendDiaryService.friendListSelectAll(myEmail);

            model.addAttribute("friendList",friendList);
            } else {

            // 친구 검색 리스트

            List<Map<String, Object>> search = friendDiaryService.search(myEmail,searchKeyword);

            model.addAttribute("friendList", search);

            }

            // 친구리스트 카운트해서 가져오기
            int friendListCount = friendDiaryService.friendListCount(myEmail);

            model.addAttribute("friendListCount",friendListCount);

            return "user/noticePage/friendList";
        }


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
        // 알림 myEmail 유저한테 온거 select
        List<Map<String, Object>> notifiSelect = notifiService.notifiSelect(myEmail);

        model.addAttribute("notifiSelectList",notifiSelect);
        model.addAttribute("memberList",memberList);
        model.addAttribute("friendSendList",friendSendList);
        return "user/noticePage/sendList";
    }

    // 모달 친구신청
    @RequestMapping("/addSendList")
    @ResponseBody
    public String addSendList(HttpServletRequest request, @RequestParam String member_email, @RequestParam String response) {

        String myEmail = (String)request.getSession().getAttribute("loginUser");

        friendDiaryService.insertfriendSend(new FriendSend(0,myEmail,member_email,response,null));

        // 알림 insert
        // 알림 구분자
        String noti_type = "friend";
        notifiService.notifiInsert(new Notifi(0,myEmail,0,member_email,noti_type,null,null,null));

        return "success";
    }

    // modal member 검색하기
    @RequestMapping(value = "modalSearch", method = {RequestMethod.POST})
    public String modalSearch(HttpServletRequest request, @RequestParam String searchKeyword, Model model) {

        String myEmail = (String)request.getSession().getAttribute("loginUser");

        List<Map<String, Object>> memberSearch = friendDiaryService.memberSearch(myEmail,searchKeyword);

        model.addAttribute("memberList",memberSearch);
        return "user/noticePage/sendList :: .modalBody";
    }

    // 친구 수락/거절
    @RequestMapping("/response")
    @ResponseBody
    public String response(HttpServletRequest request, @RequestParam String member_op_email, String response, Integer fri_send_seq) {

        String myEmail = (String)request.getSession().getAttribute("loginUser");

        if(response.equals("y")) {
            friendDiaryService.insertfriendList(new FriendApply(0,myEmail,member_op_email,null,0));
            friendDiaryService.deleteFriendSend(fri_send_seq);
        } else {
            friendDiaryService.deleteFriendSend(fri_send_seq);
        }
        return "success";
    }

    // 친구의 다이어리로 이동
    @RequestMapping(value="/frndDiary")
    public String friendDiary(HttpServletRequest request,
                              Model model,
                              @RequestParam String frndEmail) {


        // 로그인유저의 세션정보 가져오기 (이메일주소)
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/";
        } else {

            // 해당 친구의 일기 가져오기
            List<HashMap<String, Object>> myDiaryList = diaryService.oneDiarySelectAll(frndEmail);

            // 친구 일기 가져오기
            List<HashMap<String, Object>> friendDiaryList = diaryService.friendDiarySelectAll((String) loginUser);
            model.addAttribute("memberSeq", frndEmail);
            model.addAttribute("myDiaryList", myDiaryList);
            model.addAttribute("friendDiaryList", friendDiaryList);

            return "user/userDiary/frndDiary";
        }
    }

    // 친구캘린더 데이터
    @RequestMapping(value = "/frndCalendar")
    @ResponseBody
    public JSONArray getCalendarList(HttpServletRequest request,
                                     Model model,
                                     @RequestParam String memberSeq
    )  {

        List<Map<String,Object>> diaryList = diaryService.frndCalendarDiarySelectAll(memberSeq);

        JSONArray result = new JSONArray();
        result.addAll(diaryList);

        //System.out.println("db에서 갓 나옴 : "+diaryList);
        //System.out.println("json으로 변환 : "+ result);
        return result;
    }


}
