package com.go.ogamprj.controller.user;

import com.go.ogamprj.dto.Bgimage;
import com.go.ogamprj.dto.Member;
import com.go.ogamprj.mapper.MemberMapper;
import com.go.ogamprj.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.UUID;


@Controller
public class User_MyPageController {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberMapper memberMapper;


    @Value("${upload.path}")
    private String fileDir;


    @RequestMapping("/MyPage")
    public String MyPage(HttpServletRequest request, Model model) {
        String member_email = "annjin21@naver.com";
//        request.getSession().setAttribute("member_email", "user2@ogam.com");
//        String member_email = (String) request.getSession().getAttribute("member_email");
        System.out.println(member_email);
        HashMap<String, Object> user = memberService.findMember(member_email);
//        System.out.println(user.get("BGIMG_PATH"));

        model.addAttribute("member", user);
        String[] birth = user.get("MEMBER_BIRTH").toString().split("/");
        model.addAttribute("year", birth[0]);
        model.addAttribute("month", birth[1]);
        model.addAttribute("day", birth[2]);
//        System.out.println(birth.length);
        return "user/myPage/reviseInfo";
    }

    @RequestMapping("/unique")
    @ResponseBody
    public int unique(@RequestParam String member_nick) {
        String member_email = "user3@ogam.com";
        int name = memberMapper.uniqueChk(member_nick, member_email);

        return name;
    }

    @RequestMapping("/reviseInfo")
    public String reviseInfo() {

        return "redirect:/MyPage";
    }

    @RequestMapping("/reviseUpdate")
    public String reviseUpdate(HttpServletRequest request
                              , @RequestParam String member_email, @RequestParam String member_pw
                              , @RequestParam String member_nick, @RequestParam String member_birth1
                              , @RequestParam String member_birth2, @RequestParam String member_birth3
                              , @RequestParam String member_phone, @RequestParam MultipartFile file
                              , @RequestParam String member_intro) {

        String member_birth = member_birth1 + "/" + member_birth2 + "/" + member_birth3;
        Member member = new Member(member_pw, member_nick, member_birth, member_phone, member_intro, 0);
        member.setMEMBER_EMAIL(member_email);

        if(file.isEmpty()) {
            memberService.noProfile(member);
        } else {
            String realPath = request.getSession().getServletContext().getRealPath("/");
            String originName = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            String extension = originName.substring(originName.lastIndexOf("."));
            String savName = uuid + extension;

            String savedPath = realPath + fileDir + savName; // 서버 저장 경로

            Bgimage bgimageDto = new Bgimage(0, fileDir + savName, savName);
            try {
                file.transferTo(new File(savedPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            memberService.reviseUpdate(member, bgimageDto);
        }
        return "redirect:/MyPage";
    }

    public static void init(HttpServletResponse response) {
        response.setContentType("text/html; charset=euc-kr");
        response.setCharacterEncoding("euc-kr");
    }

    @RequestMapping("/delMember")
    public String delMemberPwd(HttpServletRequest request
                               , HttpServletResponse response
                               , @RequestParam String member_pw,
                                @RequestParam(defaultValue = "") String member_quited_reason) throws IOException {
        String member_email = "user2@ogam.com";

        int pwd = memberMapper.delMemberPwd(member_email, member_pw);
        PrintWriter out = response.getWriter();
        init(response);

        if(pwd == 0) {
            out.println("<script>alert('not matched password!'); location.href='/MyPage'</script>");
            out.flush();
        }
        memberMapper.delMember(member_quited_reason, member_email);
        return "redirect:/";
    }


}
