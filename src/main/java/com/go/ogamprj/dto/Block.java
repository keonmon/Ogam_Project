package com.go.ogamprj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Block {

    private int BLOCK_SEQ;
    private String MEMBER_EMAIL;
    private String BLOCK_EMAIL;

    public Block(String MEMBER_EMAIL, String BLOCK_EMAIL){
        this.MEMBER_EMAIL = MEMBER_EMAIL;
        this.BLOCK_EMAIL = BLOCK_EMAIL;
    }
}
