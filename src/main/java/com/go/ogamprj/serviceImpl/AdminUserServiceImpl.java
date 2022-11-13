package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.dto.Member;
import com.go.ogamprj.mapper.AdminUserMapper;
import com.go.ogamprj.sevice.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    AdminUserMapper adminUserMapper;

    /* USER 전체 가져오기 */
    @Override
    public ArrayList<Member> userSelectAll() {
        return adminUserMapper.userSelectAll();
    }

    /* 키워드 검색 */
    @Override
    public ArrayList<Member> userSelectKeyword(String type, String keyword) {
        return adminUserMapper.userSelectKeyword(type, keyword);
    }

    /* 사용자 상세 정보 */
    @Override
    public Map<String, Object> userSelectOne(String member_email) {
        return adminUserMapper.userSelectOne(member_email);
    }

    /* 일기 신고 수 count*/
    @Override
    public int diaryCount(String member_email) {
        return adminUserMapper.diaryCount(member_email);
    }
    /* 댓글 신고 수 count */
    @Override
    public int replyCount(String member_email) {
        return adminUserMapper.replyCount(member_email);
    }

    /* 계정 정지 */
    @Override
    public void userUpdate(Member member) {
        adminUserMapper.userUpdate(member);
    }
}
