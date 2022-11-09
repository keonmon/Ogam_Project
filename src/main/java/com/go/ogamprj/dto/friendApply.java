package com.go.ogamprj.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@ToString
public class friendApply {

    private int fri_app_seq;        // 친구목록_고유번호
    private String member_email;    // 이메일
    private String member_op_email; // 상대 이메일
    private Date friend_date;       // 신청일
}
