package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.mapper.DashboardMapper;
import com.go.ogamprj.sevice.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    DashboardMapper dashboardMapper;

    @Override
    public int users() {
        return dashboardMapper.users();
    }

    @Override
    public int removeUser() {
        return dashboardMapper.removeUser();
    }

    @Override
    public int diary() {
        return dashboardMapper.diary();
    }

    @Override
    public List<HashMap<String, Object>> blackcnt() {

        return dashboardMapper.blackcnt();
    }

    @Override
    public ArrayList<String> emotionList() {
        return dashboardMapper.emotionList();
    }

    @Override
    public ArrayList<Integer> cntList() {
        return dashboardMapper.cntList();
    }

    @Override
    public int diaryCnt() {
        return dashboardMapper.diaryCnt();
    }

    @Override
    public int memberCnt() {
        return dashboardMapper.memberCnt();
    }
}
