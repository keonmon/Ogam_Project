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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
        String member_email = "user1@ogam.com";
        Member user = memberService.findMember(member_email);

        model.addAttribute("member", user);
        String[] birth = user.getMEMBER_BIRTH().split("/");
        model.addAttribute("year", birth[0]);
        model.addAttribute("month", birth[1]);
        model.addAttribute("day", birth[2]);
        System.out.println(birth.length);
        String phone = user.getMEMBER_PHONE().replace("-", "");
        model.addAttribute("phone", phone);
        return "user/myPage/reviseInfo";
    }

    @RequestMapping("/unique")
    @ResponseBody
    public int unique(@RequestParam String member_nick) {
        System.out.println(member_nick);
        int success = memberMapper.uniqueChk(member_nick);

        return success;
    }

    @RequestMapping("/reviseInfo")
    public String reviseInfo() {

        return "redirect:/MyPage";
    }

    @RequestMapping("/reviseUpdate")
    public String reviseUpdate(HttpServletRequest request
                              , @RequestParam String member_email, @RequestParam(required = false) String member_pw
                              , @RequestParam String member_nick, @RequestParam String member_birth1
                              , @RequestParam String member_birth2, @RequestParam String member_birth3
                              , @RequestParam String member_phone, @RequestParam(defaultValue = "") MultipartFile member_image
                              , @RequestParam String member_intro, @RequestParam MultipartFile file) throws IOException {

        String realPath = request.getSession().getServletContext().getRealPath("/");
        String originName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = originName.substring(originName.lastIndexOf("."));

        String savName = uuid + extension;

        String savedPath = realPath + fileDir + savName; // 서버 저장 경로

        Bgimage bgimageDto = new Bgimage(0, fileDir + savName, savName);

        file.transferTo(new File(savedPath));




        String member_birth = member_birth1 + "/" + member_birth2 + "/" + member_birth3;
//        Member member = new Member(member_pw, member_nick, member_birth, member_phone, member_intro);
//        System.out.println(member);
//        member.setMEMBER_EMAIL(member_email);
//        memberService.reviseUpdate(member);
        return "redirect:/MyPage";
    }

}
