package com.go.ogamprj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Notifi {

    private int noti_seq;
    private String member_email;
    private int diary_seq;
    private String noti_email;
    private String noti_type;
    private Date noti_date;
    private Date noti_readdate;
    private String noti_comm;
}
