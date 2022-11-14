package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Member;

import java.util.Map;

public interface LoginService {

    public Map<String,Object> memberSelectOne(String member_email);

    public String idFindSelectOne(String member_birth, String member_phone);


    void updateUserPassword(String uuid, String member_email);
}
