package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Member;

public interface LoginService {

    public boolean loginvalid(String member_email, String member_pw);

    public boolean findid(String member_birth, String member_phone);

    public boolean findpw(String member_email, String member_phone);
}
