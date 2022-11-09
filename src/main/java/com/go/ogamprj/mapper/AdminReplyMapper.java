package com.go.ogamprj.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AdminReplyMapper {

    /* USER 댓글 전체 가져오기 */
    public List<HashMap<String, Object>> userReplySelectAll();
}
