package com.go.ogamprj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {

    private int REPLY_SEQ;           // 댓글 고유번호
    private int DIARY_SEQ;           // 일기 고유번호
    private String MEMBER_EMAIL;     // 회원 이메일
    private String REPLY;            // 댓글 내용
    private Date REPLY_DATE;         // 댓글 작성일
    private String REPLY_DEL;        // 댓글 삭제구분 (n:기본값)

}
