package com.go.ogamprj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class Diary {
    private int DIARY_SEQ;           // 일기 고유번호
    private String MEMBER_EMAIL;     // 회원 이메일
    private int BGIMG_SEQ;           // 배경파일 고유번호
    private int EMOTION_SEQ;         // 감정 고유번호
    private String CONTENTS;         // 내용
    private Date DIARY_DATE;         // 작성일
    private String DIARY_PRIVATE;    // 비공개 유무 (n:공개 / y:비공개)
    private String DIARY_DEL;        // 일기 삭제 유무
};

