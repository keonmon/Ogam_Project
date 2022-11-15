package com.go.ogamprj.sevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface DashboardService {

    // 탈퇴, admin계정을 제외한 count
    int users();

    // admin계정을 제외한 탈퇴 회원 count
    int removeUser();

    // 삭제한 일기를 제외한 일기 count
    int diary();

    // 신고된 일기 + 댓글
    List<HashMap<String, Object>> blackcnt();

    // 차트 1달 이내의 데이터만 가져오기 (emotion)
    ArrayList<String> emotionList();

    // 1달 이내의 각 감정의 데이터 count
    ArrayList<Integer> cntList();

    // 하루동안 작성된 일기 개수
    int diaryCnt();

    // 한달간 신규 가입자 수
    int memberCnt();

}
