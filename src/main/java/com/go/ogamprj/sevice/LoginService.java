package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Member;

import java.util.Map;

public interface LoginService {

    public Map<String,Object> memberSelectOne(String member_email);

    public String idFindSelectOne(String member_birth, String member_phone);

    public boolean findpw(String member_email, String member_phone);
}
