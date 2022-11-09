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

        // 랜덤하게 다이어리 가져오기 (10개)
        //List<HashMap<String,Object>> randomAllDiaryList = ;
        List<HashMap<String, Object>> result = changeDateFormat(diaryMapper.randomAllDiarySelectAll());
        System.out.println(result);

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

        // 날짜변경
        Date diary_date = (Date)resultMap.get("DIARY_DATE");
        String formatedDate = sdf.format(diary_date);
        resultMap.replace("DIARY_DATE",formatedDate);





        return resultMap;
    }


    /**
     * 날짜 형식 바꾸기 함수
     * yy.MM.dd.EEE 형식으로 변환 (Locale.ENGLISH)
     * @param diaryList
     * @return
     */
    public List<HashMap<String,Object>> changeDateFormat(List<HashMap<String,Object>> diaryList){
        Date diary_date;
        SimpleDateFormat sdf = new SimpleDateFormat("yy. MM. dd. EEE", Locale.ENGLISH);

        for( int i = 0; i < diaryList.size(); i++){
            diary_date = (Date)diaryList.get(i).get("DIARY_DATE");
            String formatedDate = sdf.format(diary_date);
            diaryList.get(i).replace("DIARY_DATE",formatedDate);
        }
        return diaryList;
    }





}
