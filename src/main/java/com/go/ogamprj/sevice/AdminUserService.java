package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Member;

import java.util.ArrayList;


public interface AdminUserService {

    public ArrayList<Member> userSelectAll();   // USER 전체 가져오기
}
