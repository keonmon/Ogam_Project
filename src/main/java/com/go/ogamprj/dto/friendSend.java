package com.go.ogamprj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@ToString
public class friendSend {
    private int fri_send_seq;
    private String member_email;
    private String member_op_email;
    private String response;
    private Date send_date;
}
