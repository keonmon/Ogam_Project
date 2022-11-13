package com.go.ogamprj.controller.user;

import com.go.ogamprj.sevice.KakaoAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class User_KakaoAPIController {

    @Autowired
    KakaoAPIService kakaoApiService;
    // 카카오 로그인 인증 절차

    @RequestMapping(value="/kakaoLogin")
    public String kakaoLogin(@RequestParam("code") String code,
                                   HttpSession session){
        ModelAndView mav = new ModelAndView();

        // 1번 : 인증코드 요청 전달
        String accessToken = kakaoApiService.getAccessToken(code);
        // 2번 : 인증코드 전달
        HashMap<String, Object> userInfo = kakaoApiService.getUserInfo(accessToken);


        // 카카오로부터 받은 정보 DB에 INSERT
        //  - 넘어온 데이터 확인
        System.out.println("userInfo : " + userInfo);

        // 넘어온 데이터에 이메일이 없다면 unlink실행
        if(userInfo.get("email") == null){
            System.out.println();
            return "redirect:/kakaoUnlink";
        }

        // 넘어온 데이터와 일치하는 데이터가 있는지 확인
        HashMap<String,Object> checkUser = kakaoApiService.kakaoUserCheck(userInfo.get("kakaoId"));
        if(checkUser == null){
            // 데이터 insert
            kakaoApiService.kakaoUserInsert(userInfo);
        }

        // 세션에 로그인 정보 담기
        if(userInfo.get("email") != null){
            session.setAttribute("loginUser",userInfo.get("email"));
            session.setAttribute("accessToken",accessToken);
        }

        return "redirect:/";
    }

    @RequestMapping(value="/kakaoUnlink")
    public String unlink(HttpSession session) {
        kakaoApiService.unlink((String)session.getAttribute("accessToken"));
        kakaoApiService.unlink((String)session.getAttribute("loginUser"));
        session.invalidate();
        return "redirect:/";
    }



}
