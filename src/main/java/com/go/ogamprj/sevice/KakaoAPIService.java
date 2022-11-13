package com.go.ogamprj.sevice;

import java.util.HashMap;

public interface KakaoAPIService {

    public String getAccessToken(String code);

    public HashMap<String, Object> getUserInfo(String accessToken);

    public void kakaoLogout(String accessToken);

    void kakaoUserInsert(HashMap<String, Object> userInfo);

    HashMap<String,Object> kakaoUserCheck(Object kakaoId);

    void unlink(String access_token);
}
