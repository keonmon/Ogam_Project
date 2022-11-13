package com.go.ogamprj.serviceImpl;


import com.go.ogamprj.dto.Bgimage;
import com.go.ogamprj.dto.Diary;
import com.go.ogamprj.dto.Emotions;
import com.go.ogamprj.mapper.DiaryMapper;
import com.go.ogamprj.sevice.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    DiaryMapper diaryMapper;

    @Override
    public List<HashMap<String,Object>> oneDiarySelectAll(String myEmail) {


        // 내 일기 가져오기
        List<HashMap<String,Object>> myDiaryList = diaryMapper.oneDiarySelectAll(myEmail);

        // 날짜형식 바꾸기
        List<HashMap<String,Object>> result = changeDateFormat(myDiaryList);

        return result;
    }

    @Override
    public List<HashMap<String, Object>> friendDiarySelectAll(String myEmail) {
        // 내 친구 찾기
        //String[] friends = diaryMapper.friendEmailSelectAll(myEmail);
        //for(String friend : friends){
        //    diaryMapper.selectAllDiary(myEmail)
        //}

        // 내 친구들의 다이어리 List<HashMap<String,Object>>로 담기
        List<HashMap<String,Object>> friendDiaryList = diaryMapper.friendDiarySelectAll(myEmail);

        // 날짜형식 바꾸기
        List<HashMap<String,Object>> result = changeDateFormat(friendDiaryList);

        return result;
    }

    @Override
    public List<HashMap<String, Object>> randomAllDiarySelectAll() {

        // 랜덤하게 다이어리 가져오기 (15개)
        //List<HashMap<String,Object>> randomAllDiaryList = ;
        List<HashMap<String, Object>> result = changeDateFormat(diaryMapper.randomAllDiarySelectAll());
        //System.out.println(result);

        return result;
    }

    @Override
    public ArrayList<Emotions> getEmotions(String emotion) {
        return diaryMapper.getEmotions(emotion);
    }

    @Override
    public String getEmojiSelectOne(int emotion_seq) {
        return diaryMapper.getEmojiSelectOne(emotion_seq);
    }

    @Override
    public void diaryInsertWithBgimg(Bgimage bgimageDto, Diary diaryDto) {
        // 파일경로, 파일명 db에 저장
        diaryMapper.bgimageInsert(bgimageDto);

        // 배경이미지테이블에서 마지막에 저장된 seq 추출
        //int bgimg_seq = diaryMapper.bgimageSelectLastSeq();

        // 다이어리를 저장할 때 서브쿼리로 이미지 seq추출을 포함
        diaryMapper.diaryInsertWithBgimg(diaryDto);
    }

    @Override
    public int diarySelectLastOne() {
        return diaryMapper.diarySelectLastOne();
    }

    @Override
    public void diaryInsertNoBgimg(Diary diaryDto) {
        // 다이어리를 저장 - 배경이미지 제외
        diaryMapper.diaryInsertNoBgimg(diaryDto);
    }

    @Override
    public HashMap<String, Object> diarySelectOne(int diarySeq) {
        SimpleDateFormat sdf = new SimpleDateFormat("yy. MM. dd. EEE", Locale.ENGLISH);

        HashMap<String,Object> resultMap = diaryMapper.diarySelectOne(diarySeq);
        if(resultMap == null){
            return resultMap;
        }


        // 날짜변경
        Date diary_date = (Date)resultMap.get("DIARY_DATE");
        String formatedDate = sdf.format(diary_date);
        resultMap.replace("DIARY_DATE",formatedDate);

        return resultMap;
    }


    @Override
    public HashMap<String,Object> likeMap(int diary_seq) {
        HashMap<String,Object> likeMap = new HashMap<>();

        likeMap.put("likeCnt",diaryMapper.likeCnt(diary_seq));
        likeMap.put("likeMemberList",diaryMapper.likeMemberList(diary_seq));

        return likeMap;
    }

    @Override
    public List<HashMap<String,Object>> replySelect(int diarySeq) {

        List<HashMap<String,Object>> replyList = diaryMapper.replySelect(diarySeq);

        // 날짜 변환
        List<HashMap<String,Object>> resultList = changeDateFormat(replyList);

        return resultList;
    }

    @Override
    public void diaryUpdateNoBgimg(Diary diaryDto) {
        diaryMapper.diaryUpdateNoBgimg(diaryDto);
    }

    @Override
    public void diaryUpdateWithBgimg(Bgimage bgimageDto, Diary diaryDto) {
        // 파일경로, 파일명 db에 저장
        diaryMapper.bgimageInsert(bgimageDto);

        // 배경이미지테이블에서 마지막에 저장된 seq 추출
        //int bgimg_seq = diaryMapper.bgimageSelectLastSeq();

        // 다이어리를 수정할 때 서브쿼리로 이미지 seq추출을 포함
        diaryMapper.diaryUpdateWithBgimg(diaryDto);
    }

    @Override
    public void replyUpdate(int reply_seq, String reply) {
        diaryMapper.replyUpdate(reply_seq, reply);
    }

    @Override
    public int getDiarySeq(int reply_seq) {
        return diaryMapper.getDiarySeq(reply_seq);
    }

    @Override
    public void diaryDelete(int diary_seq) {
        diaryMapper.diaryDelete(diary_seq);
    }

    @Override
    public void replyDelete(int reply_seq) {
        diaryMapper.replyDelete(reply_seq);
    }

    @Override
    public void diaryReportInsert(int diary_seq, String member_email, String blacklist_user_email, String blacklist_comment) {
        diaryMapper.diaryReportInsert(diary_seq,member_email,blacklist_user_email,blacklist_comment);
    }

    @Override
    public void replyReportInsert(int reply_seq, String member_email, String blacklist_member_email, String blacklist_comment) {
        diaryMapper.replyReportInsert(reply_seq,member_email,blacklist_member_email,blacklist_comment);
    }

    @Override
    public void replyInsert(Map<String, Object> replyMap) {
        diaryMapper.replyInsert(replyMap);

    }

    @Override
    public void likeInsert(String member_email, int diary_seq) {
        diaryMapper.likeInsert(member_email,diary_seq);
    }

    @Override
    public void likeDelete(String member_email, int diary_seq) {
        diaryMapper.likeDelete(member_email,diary_seq);
    }

    @Override
    public List<Map<String,Object>> calendarDiarySelectAll(String memberSeq) {
        return diaryMapper.calendarDiarySelectAll(memberSeq);
    }

    @Override
    public List<Map<String, Object>> frndCalendarDiarySelectAll(String memberSeq) {
        return diaryMapper.frndCalendarDiarySelectAll(memberSeq);
    }

    @Override
    public void notifyReplyInsert(Map<String, Object> replyMap) {
        diaryMapper.notifyReplyInsert(replyMap);
    }

    @Override
    public void notifyLikeInsert(Map<String, Object> map) {

        int cnt = diaryMapper.notifyLikeSelectCnt(map);  // 이미 좋아요를 했는지 확인

        // count 결과가 0이면 좋아요 알림 전송
        if(cnt == 0){
            diaryMapper.notifyLikeInsert(map);
        }
    }


    /**
     * 날짜 형식 바꾸기 함수
     * yy.MM.dd.EEE 형식으로 변환 (Locale.ENGLISH)
     * @param list
     * @return
     */
    public List<HashMap<String,Object>> changeDateFormat(List<HashMap<String,Object>> list){
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("yy. MM. dd. EEE", Locale.ENGLISH);

        for( int i = 0; i < list.size(); i++){
            if(list.get(i).containsKey("DIARY_DATE")) {
                date = (Date) list.get(i).get("DIARY_DATE");
                String formatedDate = sdf.format(date);
                list.get(i).replace("DIARY_DATE", formatedDate);
            }else if(list.get(i).containsKey("REPLY_DATE")){
                date = (Date) list.get(i).get("REPLY_DATE");
                String formatedDate = sdf.format(date);
                list.get(i).replace("REPLY_DATE", formatedDate);
            }
        }
        return list;
    }





}
