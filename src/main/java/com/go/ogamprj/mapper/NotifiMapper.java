package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.Notifi;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NotifiMapper {

    void notifiInsert(Notifi notifi);

    List<Map<String, Object>> notifiSelect(String myEmail);


    void deleteNotifi(int noti_seq);
}
