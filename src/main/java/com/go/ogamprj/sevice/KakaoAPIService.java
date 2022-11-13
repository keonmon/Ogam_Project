package com.go.ogamprj.sevice;

import java.util.HashMap;

public interface KakaoAPIService {

    public String getAccessToken(String code);

    public HashMap<String, Object> getUserInfo(String accessToken);

    public void kakaoLogout(String accessToken);
}
