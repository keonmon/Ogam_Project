package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Notifi;

import java.util.List;
import java.util.Map;

public interface NotifiService {

    void notifiInsert(Notifi notifi);

    List<Map<String, Object>> notifiSelect(String myEmail);

    void deleteNotifi(int noti_seq);


}
