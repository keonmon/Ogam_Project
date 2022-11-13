package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Member;

public interface SignupService {

  Member insert(Member member);

  int uniqueEmail(String member_email);

  int uniqueChk(String member_nick);
}
