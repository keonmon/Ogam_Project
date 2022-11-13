package com.go.ogamprj.controller.user;

import com.go.ogamprj.serviceImpl.KakaoAPIServiceImpl;
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
    KakaoAPIServiceImpl kakaoApiServiceImpl;
    // 카카오 로그인 인증 절차

    @RequestMapping(value="/kakaoLogin")
    public ModelAndView kakaoLogin(@RequestParam("code") String code,
                                   HttpSession session){
        ModelAndView mav = new ModelAndView();

        // 1번 : 인증코드 요청 전달
        String accessToken = kakaoApiServiceImpl.getAccessToken(code);
        // 2번 : 인증코드 전달
        HashMap<String, Object> userInfo = kakaoApiServiceImpl.getUserInfo(accessToken);

        System.out.println("login info : " + userInfo.toString());

        //

        if(userInfo.get("email") != null){
            session.setAttribute("userId",userInfo.get("email"));
            session.setAttribute("accessToken",accessToken);
        }
        mav.addObject("userId",userInfo.get("email"));
        mav.setViewName("redirect:/");
        return mav;
    }

    @RequestMapping(value = "/kakaoLogout")
    public ModelAndView kakaoLogout(HttpSession session){
        ModelAndView mav = new ModelAndView();

        kakaoApiServiceImpl.kakaoLogout((String)session.getAttribute("accessToken"));
        session.removeAttribute("accessToken");
        session.removeAttribute("userId");
        mav.setViewName("redirect:/");


        return mav;
    }
}
