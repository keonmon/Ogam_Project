package com.go.ogamprj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlacklistReply {

    private int BLACKLIST_COM_SEQ;        // 댓글 블랙리스트 고유번호
    private int REPLY_SEQ;                  // 댓글 고유번호
    private String MEMBER_EMAIL;            // 신고자 이메일
    private String BLACKLIST_MEMBER_EMAIL;    // 피신고자 이메일
    private String BLACKLIST_COMMENT;       // 신고분류
    private Date BLACKLIST_REPLY_DATE;      // 신고일

}
