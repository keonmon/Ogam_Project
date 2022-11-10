package com.go.ogamprj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class Member {

    private String MEMBER_EMAIL;
    private String MEMBER_PW;
    private String MEMBER_NICK;
    private String MEMBER_BIRTH;
    private String MEMBER_PHONE;
    private String MEMBER_GENDER;
    private String MEMBER_ADMINYN;
    private String MEMBER_BLACKYN;
    private String MEMBER_BLACK_REASON;
    private Date MEMBER_DATE;
    private String MEMBER_IMAGE;
    private String MEMBER_INTRO;
    private Date MEMBER_QUITED;
    private String MEMBER_QUITED_REASON;

}

