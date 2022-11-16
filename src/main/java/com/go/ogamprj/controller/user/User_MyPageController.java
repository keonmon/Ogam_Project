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
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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

        Object loginUser = request.getSession().getAttribute("loginUser");

        if (loginUser == null) {
            return "redirect:/";
        } else {

            HashMap<String, Object> user = memberService.findMember(loginUser.toString());
  //        System.out.println(user.get("BGIMG_PATH"));

            model.addAttribute("member", user);
            String[] birth = user.get("MEMBER_BIRTH").toString().split("/");
            model.addAttribute("year", birth[0]);
            model.addAttribute("month", birth[1]);
            model.addAttribute("day", birth[2]);
            System.out.println(birth[0] +" "+ birth[1] +" "+ birth[2] );
            return "user/myPage/reviseInfo";
        }
    }

    @RequestMapping("/unique")
    @ResponseBody
    public int unique(@RequestParam String member_nick, HttpServletRequest request) {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return 1;
        } else {
            int name = memberMapper.uniqueChk(member_nick, loginUser.toString());
            return name;


        }

    }

    @RequestMapping("/reviseInfo")
    public String reviseInfo() {

        return "redirect:/MyPage";
    }

    @RequestMapping("/reviseUpdate")
    public String reviseUpdate(HttpServletRequest request
                              , @RequestParam String member_email, @RequestParam(defaultValue = "") String member_pw
                              , @RequestParam String member_nick, @RequestParam String member_birth1
                              , @RequestParam String member_birth2, @RequestParam String member_birth3
                              , @RequestParam(defaultValue = "") String member_phone, @RequestParam MultipartFile file
                              , @RequestParam String member_intro, @RequestParam String deleteImg){

        String member_birth = member_birth1 + "/" + member_birth2 + "/" + member_birth3;
        Member member = new Member(member_pw, member_nick, member_birth, member_phone, member_intro, 0);
        member.setMEMBER_EMAIL(member_email);

        // 수정 전 유저 정보
        Map<String,Object> memberMap = memberService.findMember(member_email);

        if(file.isEmpty()) {

            if(!deleteImg.isEmpty()){
                memberService.memberUpdateResetBgimg(member);
            }else{
                // 프로필 사진 없이 저장
                memberService.noProfile(member);
            }
        } else {

            String realPath = request.getSession().getServletContext().getRealPath("/");
            String originName = file.getOriginalFilename();

            // DB에 배경이미지가 있다면?
            if(memberMap.containsKey("BGIMG_TITLE")) {
                // db의 파일명과 input File의 이름 비교해서 같다면
                if (memberMap.get("BGIMG_TITLE").equals(originName)) {
                    // 배경이미지 제외하고 다이어리 수정
                    memberService.noProfile(member);
                    return "redirect:/MyPage";
                }
            }

            String uuid = UUID.randomUUID().toString();
            String extension = originName.substring(originName.lastIndexOf("."));
            String savName = uuid + extension;

            String savedPath = realPath + fileDir + savName; // 서버 저장 경로

            Bgimage bgimageDto = new Bgimage(0, fileDir + savName, savName);

            System.out.println("사진 서버의 저장 : "+bgimageDto);

            try {
                file.transferTo(new File(savedPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            request.getSession().setAttribute("loginUserImage",fileDir + savName);
            memberService.reviseUpdate(bgimageDto, member);
            System.out.println(bgimageDto);


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
//        String member_email = "user2@ogam.com";
        String member_email = (String)request.getSession().getAttribute("loginUser");

        int pwd = memberMapper.delMemberPwd(member_email, member_pw);
        init(response);
        PrintWriter out = response.getWriter();

        if(pwd == 0) {
            out.println("<script>alert('비밀번호가 일치하지 않아요!'); location.href='/MyPage'</script>");
            out.flush();
        }
        memberMapper.delMember(member_quited_reason, member_email);

        return "redirect:/kakaoUnlink";
    }


}
