package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface AdminUserMapper {

    @Select("select * from member")
    ArrayList<Member> userSelectAll();  // USER 전체 가져오기
}
