package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.mapper.NotifiMapper;
import com.go.ogamprj.sevice.NotifiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class NotifiImpl implements NotifiService {

    @Autowired
    NotifiMapper notifiMapper;


    @Override
    public void selectMember() {
        notifiMapper.selectMember();
    }
}
