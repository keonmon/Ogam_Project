package com.go.ogamprj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    private int board_seq;        // 시퀀스
    private String board_title;
    private String board_contents;
    private Date board_date;      // SYSDATE
    private String board_yn;      // 공개유무 (기본이 n)

    public Board(String board_title, String board_contents, String board_yn) {
        this.board_title = board_title;
        this.board_contents = board_contents;
        this.board_yn = board_yn;
    }

}


