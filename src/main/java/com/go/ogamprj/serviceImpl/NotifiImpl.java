package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.dto.Notifi;
import com.go.ogamprj.mapper.NotifiMapper;
import com.go.ogamprj.sevice.NotifiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NotifiImpl implements NotifiService {

    @Autowired
    NotifiMapper notifiMapper;

    @Override
    public void notifiInsert(Notifi notifi) {
        notifiMapper.notifiInsert(notifi);
    }

    @Override
    public List<Map<String, Object>> notifiSelect(String myEmail) {
        System.out.println("값아 들어와라 : "+notifiMapper.notifiSelect(myEmail));
        return notifiMapper.notifiSelect(myEmail);
    }
}
