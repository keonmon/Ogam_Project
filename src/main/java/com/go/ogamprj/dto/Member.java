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
    private String MEMBER_DATE;
    private String MEMBER_INTRO;
    private Date MEMBER_QUITED;
    private String MEMBER_QUITED_REASON;
    private int BGIMG_SEQ;

    public Member(String MEMBER_PW, String MEMBER_NICK
                  , String MEMBER_BIRTH, String MEMBER_PHONE
                  , String MEMBER_INTRO, int BGIMG_SEQ) {
        this.MEMBER_PW = MEMBER_PW;
        this.MEMBER_NICK = MEMBER_NICK;
        this.MEMBER_BIRTH = MEMBER_BIRTH;
        this.MEMBER_PHONE = MEMBER_PHONE;
        this.MEMBER_INTRO = MEMBER_INTRO;
        this.BGIMG_SEQ = BGIMG_SEQ;
    }

    public Member(String member_email, String member_pw, String member_nick,
                  String birth, String gender, String member_phone) {
        this.MEMBER_EMAIL = member_email;
        this.MEMBER_PW = member_pw;
        this.MEMBER_NICK = member_nick;
        this.MEMBER_BIRTH = birth;
        System.out.println(birth);
        this.MEMBER_GENDER = gender;
        this.MEMBER_PHONE = member_phone;
    }
}

