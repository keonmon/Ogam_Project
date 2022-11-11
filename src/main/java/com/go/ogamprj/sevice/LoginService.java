package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Member;

public interface LoginService {

    public boolean loginvalid(String member_email, String member_pw);
}
