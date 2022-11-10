package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.dto.Member;
import com.go.ogamprj.mapper.AdminUserMapper;
import com.go.ogamprj.sevice.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    AdminUserMapper adminUserMapper;

    /* USER 전체 가져오기 */
    @Override
    public ArrayList<Member> userSelectAll() {

        return adminUserMapper.userSelectAll();
    }
}
