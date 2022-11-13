package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Member;

public interface SignupService {

  Member insert(Member member);
  int uniqueChk(String member_nick);
}
