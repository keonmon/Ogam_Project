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
import java.util.UUID;

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
                        @RequestParam String member_pw) {

        if(member_email.equals("admin@ogam.com") && member_pw.equals("Rkqhwkrh0000")){
            request.getSession().setAttribute("admin_email",member_email);
            return "redirect:/adminMain";
        }

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


        } else if(memberMap.get("MEMBER_QUITED") != null ) {

            model.addAttribute("msg","탈퇴 날짜: " + memberMap.get("MEMBER_QUITED"));

            // 로그인 성공
        }  else if(memberMap.get("MEMBER_PW").equals(member_pw)) {

            System.out.println(memberMap.get("MEMBER_BLACKYN"));

            if(memberMap.get("MEMBER_BLACKYN").equals("y")){
                model.addAttribute("msg", "정지사유:" + memberMap.get("MEMBER_BLACK_REASON"));
                return "user/loginPage/loginPage";
            }

            request.getSession().setAttribute("loginUser",member_email);
            request.getSession().setAttribute("loginUserNick",memberMap.get("MEMBER_NICK").toString());
            request.getSession().setAttribute("loginImage",memberMap.get("BGIMG_PATH"));
            return "redirect:/";

        } else{
            model.addAttribute("msg", "알 수 없는 오류가 발생했습니다.😅");
        }
            return "user/loginPage/loginPage";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session){
        request.getSession().removeAttribute("loginUser");
        request.getSession().removeAttribute("loginUserNick");
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
    public String Find(String member_email, Model model){
        model.addAttribute("member_email", member_email);
        return "user/loginPage/Find";
    }

    @RequestMapping("/Find_id")
    public String findid(@RequestParam String birth, String member_phone, Model model){

        String member_email = loginService.idFindSelectOne(birth, member_phone);
        System.out.println(member_email);
        if(member_email == null || member_email.equals("")) {
            model.addAttribute("idMsg","일치하는 회원이 존재하지 않습니다");
            return "user/loginPage/find"; // 이메일/비밀번호 찾기 창

        } else {
            model.addAttribute("member_email",member_email);
            model.addAttribute("msg", "회원님의 이메일은 [" +member_email+ "] 입니다");
            model.addAttribute("idpw","이메일");
            return "user/loginPage/find_result";    // 결과 이메일 창
        }
    }

    @RequestMapping("Find_pw")
    public String findpw(@RequestParam String member_email, String member_phone, Model model) {

        // 이메일을 통해 회원정보 가져옴
        Map<String,Object> memberMap = loginService.memberSelectOne(member_email);
        System.out.println(memberMap);

        if(memberMap == null) {
            model.addAttribute("pwMsg", "일치하는 회원이 존재하지 않습니다");
            return "user/loginPage/find"; // 이메일/비밀번호 찾기 창

        }else{
            // 번호 비교
            if(memberMap.get("MEMBER_PHONE") == null || !memberMap.get("MEMBER_PHONE").equals(member_phone)) {

                // 폰번이 다르면 카카오id유무 확인
                // 카카오id 있으면 '카카오 가입계정입니다.'
                if (memberMap.get("KAKAOID") != null) {
                    model.addAttribute("pwMsg", "해당 계정은 카카오 가입계정입니다");
                    return "user/loginPage/find"; // 이메일/비밀번호 찾기 창

                // '폰번이 일치하지 않을 경우'
                }else{
                    model.addAttribute("pwMsg", "일치하는 회원이 존재하지 않습니다");
                    return "user/loginPage/find"; // 이메일/비밀번호 찾기 창
                }

            // input 폰번과 db 폰번이 같으면 난수로직 시작
            }else {
                // 카카오 아이디 없으면 난수 생성
                String uuid = UUID.randomUUID().toString().replaceAll("-", ""); // -를 제거해 주었다.
                uuid = uuid.substring(0, 10); //uuid를 앞에서부터 10자리 잘라줌.
                System.out.println(uuid);

                loginService.updateUserPassword(uuid, member_email);

                model.addAttribute("msg", "회원님의 임시 비밀번호는 [" + uuid + "]입니다");
                model.addAttribute("idpw", "비밀번호");
                return "user/loginPage/find_result";    // 결과 이메일 창
            }
        }
    }
}
