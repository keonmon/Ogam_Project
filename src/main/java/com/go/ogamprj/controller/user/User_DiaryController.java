package com.go.ogamprj.controller.user;

import com.go.ogamprj.dto.Bgimage;
import com.go.ogamprj.dto.Diary;
import com.go.ogamprj.sevice.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class User_DiaryController {

    @Autowired
    DiaryService diaryService;

    @Value("${upload.path}")
    private String fileDir;

    @RequestMapping("/myDiary")  // http://localhost:8081/myDiary
    public String myDiary(HttpServletRequest request, Model model){

        // 로그인유저의 세션정보 가져오기 (이메일주소)
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return "redirect:/";
        }else {

            // 내 일기 가져오기
            List<HashMap<String, Object>> myDiaryList = diaryService.oneDiarySelectAll((String)loginUser);

            // 친구 일기 가져오기
            List<HashMap<String, Object>> friendDiaryList = diaryService.friendDiarySelectAll((String)loginUser);

            model.addAttribute("myDiaryList", myDiaryList);
            model.addAttribute("friendDiaryList", friendDiaryList);

            return "user/userDiary/myDiary";
        }
    }


    @RequestMapping(value="/getEmotion", method={RequestMethod.POST})
    public String getEmotion(@RequestParam Map<String,Object> emotion, Model model){
        //System.out.println(diaryService.getEmotions(emotion.get("emotion").toString()));
        model.addAttribute("emotions", diaryService.getEmotions(emotion.get("emotion").toString()));

        return "user/userDiary/writeDiary1 :: .emojiList";
    }

    @RequestMapping("/writeDiary1")
    public String writeDiary1(Model model){
        model.addAttribute("emotions", diaryService.getEmotions("기쁨"));
        return "user/userDiary/writeDiary1";
    }

    @RequestMapping("/writeDiary2")
    public String writeDiary2(HttpServletRequest request, Model model, @RequestParam int emotion_seq){
        request.getSession().setAttribute("writeEmotionSeq",emotion_seq);

        model.addAttribute("emoji", diaryService.getEmojiSelectOne(emotion_seq));
        return "user/userDiary/writeDiary2";
    }

    @RequestMapping("/writeDiary3")
    public String writeDiary3(HttpServletRequest request, Model model,
                              @RequestParam String contents,
                              @RequestParam(defaultValue = "n") String diary_private){
        request.getSession().setAttribute("writeContents",contents);
        //request.getSession().setAttribute("writePrivate",diary_private);


        int emotion_seq = (int)request.getSession().getAttribute("writeEmotionSeq");
        model.addAttribute("emoji", diaryService.getEmojiSelectOne(emotion_seq));
        model.addAttribute("writePrivate",diary_private);
        return "user/userDiary/writeDiary3";
    }

    @RequestMapping(value = "/insertDiary",method = RequestMethod.POST)
    public String insertDiary(HttpServletRequest request, Model model,
                              @RequestParam(defaultValue = "n") String diary_private,
                              @RequestParam MultipartFile file){

        request.getSession().setAttribute("writePrivate",diary_private);
        int writeEmotionSeq = (int)request.getSession().getAttribute("writeEmotionSeq");
        String writeContents = (String)request.getSession().getAttribute("writeContents");
        String loginUser = (String)request.getSession().getAttribute("loginUser");

        Diary diaryDto = new Diary(0, loginUser, 0, writeEmotionSeq, writeContents, null, diary_private, "n");

        // 업로드된 파일 처리
            // 이미지를 업로드하지 않는 경우
        if(file.isEmpty()) {
            // 배경이미지를 제외하고 다이어리 저장
            diaryService.diaryInsertNoBgimg(diaryDto);
        } else {

            // 파일 업로드 준비
            // 서버 webapp 경로 추출
            String realPath = request.getSession().getServletContext().getRealPath("/");

            // file의 실제이름 추출
            String origName = file.getOriginalFilename();

            // 파일 이름으로 쓸 uuid 생성
            String uuid = UUID.randomUUID().toString();

            // 확장자 추출(ex : .png)
            String extension = origName.substring(origName.lastIndexOf("."));

            // uuid와 확장자 결합
            String savedName = uuid + extension;

            // 파일을 불러올 때 사용할 파일 경로
            String savedPath = realPath + fileDir + savedName;

            Bgimage bgimageDto = new Bgimage(0, fileDir + savedName, savedName);
            // 파일 서버에 저장
            try {
                file.transferTo(new File(savedPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // 다이어리 DB에 저장(파일과 함께 가져감
            diaryService.diaryInsertWithBgimg(bgimageDto, diaryDto);
        }

        // 마지막 저장된 diarySeq 조회
        int diarySeq = diaryService.diarySelectLastOne();

        return "redirect:/viewDiary?diarySeq="+diarySeq;
    }


    // /viewDiary?diarySeq="+diarySeq
    @RequestMapping("/viewDiary")
    public String DiaryView(HttpServletRequest request,
                            Model model,
                            @RequestParam int diarySeq){
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return "redirect:/";
        }else {
            // 다이어리와 배경이미지를 조인한 결과를 해시맵에 담음
            HashMap<String, Object> diaryDto = diaryService.diarySelectOne(diarySeq);


            // 파일 경로에 realPath 덧붙이기
            //String realPath = request.getSession().getServletContext().getRealPath("/");
            //String editedPath = realPath + "/" + diaryDto.get("BGIMG_PATH");
            //diaryDto.replace("BGIMG_PATH",editedPath);

            // 해당 게시물의 댓글 가져오기
            List<HashMap<String, Object>> replyList = diaryService.replySelect(diarySeq);

            // 좋아요 가져오기 (해당 게시물의 좋아요 개수, 좋아요한 사람 리스트)
            HashMap<String, Object> likeMap = diaryService.likeMap(diarySeq);


            System.out.println(diaryDto);
            System.out.println(replyList);
            System.out.println(likeMap);

            model.addAttribute("diaryDto", diaryDto);    // 다이어리
            model.addAttribute("replyList", replyList);  // 댓글
            model.addAttribute("likeMap", likeMap);     // 좋아요

            return "user/userDiary/viewDiary";
        }
    }




    // 일기 수정 폼1으로 이동
    @RequestMapping("/diaryUpdateForm1")
    public String diaryUpdateForm1(HttpServletRequest request,
                                  @RequestParam String id,
                                  Model model){
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return "redirect:/";
        }else {
            request.getSession().setAttribute("updateDirId", id);    // 게시물번호 세션에 저장

            // 기존 일기 데이터 조회
            HashMap<String, Object> diaryMap = diaryService.diarySelectOne(Integer.parseInt(id));

            System.out.println(diaryMap);
            model.addAttribute("diaryMap", diaryMap);
            model.addAttribute("emotions", diaryService.getEmotions("기쁨"));
            return "user/userDiary/updateDiary1";
        }
    }

    // 일기 수정폼 2
    @RequestMapping("/diaryUpdateForm2")
    public String diaryUpdateForm2(HttpServletRequest request, Model model, @RequestParam int emotion_seq){
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return "redirect:/";
        }else {
            request.getSession().setAttribute("writeEmotionSeq", emotion_seq);
            String id = (String) request.getSession().getAttribute("updateDirId");

            // 기존 일기 데이터 조회
            HashMap<String, Object> diaryMap = diaryService.diarySelectOne(Integer.parseInt(id));

            model.addAttribute("diaryMap", diaryMap);
            model.addAttribute("emoji", diaryService.getEmojiSelectOne(emotion_seq));
            return "user/userDiary/updateDiary2";
        }
    }

    // 일기 수정폼 3
    @RequestMapping("/diaryUpdateForm3")
    public String diaryUpdateForm3(HttpServletRequest request, Model model,
                              @RequestParam String contents,
                              @RequestParam(defaultValue = "n") String diary_private){
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return "redirect:/";
        }else {
            request.getSession().setAttribute("writeContents", contents);
            //request.getSession().setAttribute("writePrivate",diary_private);

            String id = (String) request.getSession().getAttribute("updateDirId");
            // 기존 일기 데이터 조회
            HashMap<String, Object> diaryMap = diaryService.diarySelectOne(Integer.parseInt(id));

            int emotion_seq = (int) request.getSession().getAttribute("writeEmotionSeq");
            model.addAttribute("emoji", diaryService.getEmojiSelectOne(emotion_seq));
            model.addAttribute("writePrivate", diary_private);
            model.addAttribute("diaryMap", diaryMap);
            return "user/userDiary/updateDiary3";
        }
    }

    // 일기 수정 시작
    @RequestMapping(value = "/updateDiary",method = RequestMethod.POST)
    public String updateDiary(HttpServletRequest request, Model model,
                              @RequestParam(defaultValue = "n") String diary_private,
                              @RequestParam MultipartFile file){
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return "redirect:/";
        }else {
            request.getSession().setAttribute("writePrivate", diary_private);
            int writeEmotionSeq = (int) request.getSession().getAttribute("writeEmotionSeq");
            String writeContents = (String) request.getSession().getAttribute("writeContents");
            String id = (String) request.getSession().getAttribute("updateDirId");

            // 기존 일기 데이터 조회
            HashMap<String, Object> diaryMap = diaryService.diarySelectOne(Integer.parseInt(id));

            Diary diaryDto = new Diary(Integer.parseInt(id), (String) loginUser, 0, writeEmotionSeq, writeContents, null, diary_private, "n");

            // 업로드된 파일 처리
            // 이미지를 업로드하지 않는 경우
            if (file.isEmpty()) {
                // 배경이미지를 제외하고 다이어리 수정
                diaryService.diaryUpdateNoBgimg(diaryDto);
            } else {

                // 파일 업로드 준비
                // 서버 webapp 경로 추출
                String realPath = request.getSession().getServletContext().getRealPath("/");

                // file의 실제이름 추출
                String origName = file.getOriginalFilename();

                // 파일 이름으로 쓸 uuid 생성
                String uuid = UUID.randomUUID().toString();

                // 확장자 추출(ex : .png)
                String extension = origName.substring(origName.lastIndexOf("."));

                // uuid와 확장자 결합
                String savedName = uuid + extension;

                // 파일을 불러올 때 사용할 파일 경로
                String savedPath = realPath + fileDir + savedName;

                Bgimage bgimageDto = new Bgimage(0, fileDir + savedName, savedName);
                // 파일 서버에 저장
                try {
                    file.transferTo(new File(savedPath));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                // 다이어리 DB에 수정(파일과 함께 가져감)
                diaryService.diaryUpdateWithBgimg(bgimageDto, diaryDto);
            }

            return "redirect:/viewDiary?diarySeq=" + Integer.parseInt(id);
        }
    }



    // 댓글 수정
    @RequestMapping("/replyUpdateForm")
    public String replyUpdateForm(HttpServletRequest request,
                                  @RequestParam String id,
                                  @RequestParam String reply){
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return "redirect:/";
        }else{
            // 댓글 수정
            diaryService.replyUpdate(Integer.parseInt(id),reply);
            // 일기 번호 구하기
            int diaryId = diaryService.getDiarySeq(Integer.parseInt(id));

            return "redirect:/viewDiary?diarySeq=" + diaryId;
        }
    }


    // 일기 삭제
    @RequestMapping("/diaryDelete")
    public String diaryDelete(HttpServletRequest request,
                              @RequestParam String id){
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return "redirect:/";
        }else {
            // 일기 삭제
            diaryService.diaryDelete(Integer.parseInt(id));

            return "redirect:/myDiary";
        }
    }


    // 댓글 삭제
    @RequestMapping("/replyDelete")
    public String replyDelete(HttpServletRequest request,
                              @RequestParam String id){
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return "redirect:/";
        }else {
            // 댓글 삭제
            diaryService.replyDelete(Integer.parseInt(id));
            // 일기 번호 구하기
            int diaryId = diaryService.getDiarySeq(Integer.parseInt(id));
            return "redirect:/viewDiary?diarySeq=" + diaryId;
        }
    }


    // 일기 신고
    @RequestMapping("/diaryBlacklistForm")
    @ResponseBody
    public String diaryBlacklistForm(HttpServletRequest request,
                              @RequestParam String id,
                              @RequestParam String blacklist_comment,
                              @RequestParam String writer){
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return "redirect:/";
        }else {

            System.out.println("loginUser : " + (String)loginUser + " / dirId : " + id + " / comment" + blacklist_comment + " / writer" + writer);

            return "";
        }
    }

    // 댓글 신고
    @RequestMapping("/replyBlacklistForm")
    @ResponseBody
    public String replyBlacklistForm(HttpServletRequest request,
                              @RequestParam String id,
                              @RequestParam String blacklist_comment,
                              @RequestParam String writer){
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return "redirect:/";
        }else {

            System.out.println("loginUser : " + (String)loginUser + " / repId : " + id + " / comment" + blacklist_comment + " / writer" + writer);

            return "";
        }
    }








    @RequestMapping("/diaryAll")
    public String diaryAll(){
        return "user/userDiary/diaryAll";
    }

}
