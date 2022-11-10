package com.go.ogamprj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlacklistDiary {

    private int BLACKLIST_DIARY_SEQ;        // 일기 블랙리스트 고유번호
    private int DIARY_SEQ;                  // 일기 고유번호
    private String MEMBER_EMAIL;            // 신고자 이메일
    private String BLACKLIST_USER_EMAIL;    // 피신고자 이메일
    private String BLACKLIST_COMMENT;       // 신고분류
    private Date BLACKLIST_DIARY_DATE;      // 신고일

}
