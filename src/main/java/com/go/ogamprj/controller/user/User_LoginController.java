package com.go.ogamprj.controller.user;

import com.go.ogamprj.sevice.KakaoAPIService;
import com.go.ogamprj.sevice.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class User_LoginController {

    @Autowired
    KakaoAPIService kakaoAPIService;
    @Autowired
    LoginService loginService;

    @RequestMapping("/loginPage")
    public String loginPage() {

        return "user/loginPage/loginPage";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model,
                        @RequestParam String member_email,
                        @RequestParam String member_pw ) {

        // MEMBER_EMAIL, MEMBER_PW 담김
        Map<String,Object> memberMap = loginService.memberSelectOne(member_email);
        if (memberMap == null) {
            model.addAttribute("msg", "아이디가 존재하지 않습니다😅");
        } else if(memberMap.get("MEMBER_PW") == null) {
            model.addAttribute("msg", "비밀번호 오류입니다.😅");
            model.addAttribute("member_email",member_email);
        } else if(!memberMap.get("MEMBER_PW").equals(member_pw)) {
            model.addAttribute("msg", "비밀번호가 다릅니다.😅");
            model.addAttribute("member_email",member_email);
        } else if(memberMap.get("MEMBER_PW").equals(member_pw)) {
            request.getSession().setAttribute("loginUser",member_email);
            return "redirect:/";
        }else{
            model.addAttribute("msg", "알 수 없는 오류가 발생했습니다.😅");
        }
            return "user/loginPage/loginPage";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session){
        request.getSession().removeAttribute("loginUser");
        Object accessToken = request.getSession().getAttribute("accessToken");

        // 카카오로 로그인 되어있다면?
        if(accessToken != null){
            kakaoAPIService.kakaoLogout((String)session.getAttribute("accessToken"));
            session.invalidate();
            request.getSession().removeAttribute("accessToken");
        }
        return "redirect:/";
    }


    @RequestMapping("/Find")
    public String Find(){

        return "user/loginPage/Find";
    }

    @RequestMapping("/Find_id")
    public String findid(@RequestParam String birth1, String birth2,
                                       String birth3, String member_phone){

//        System.out.println("Controller=" birth1+"/"+birth2+"/"+birth3);
//        System.out.println("Controller=" member_phone);

        boolean findid = loginService.findid(birth1+"/"+birth2+"/"+birth3, member_phone);

//        System.out.println("참거짓 여부=" + findid);

        if(findid == true) {
//           System.out.println("데이터가 넘어가나요?");
            return "user/loginPage/Find_id";
        } else {

            return "redirect:/Find";
        }
//        return "user/loginPage/Find_id";
    }

    @RequestMapping("Find_pw")
    public String findpw(@RequestParam String member_email, String member_phone) {

//        System.out.println("Controller=" + member_email + " " + member_phone);

        boolean findpw = loginService.findpw(member_email, member_phone);

//        System.out.println("참거짓 여부=" + findpw);

        if (findpw == true) {
//           System.out.println("데이터가 넘어가나요?");
            return "user/loginPage/Find_pw";
        } else {

            return "redirect:/Find";
        }
//      return "user/loginPage/Find_pw";
    }
}
