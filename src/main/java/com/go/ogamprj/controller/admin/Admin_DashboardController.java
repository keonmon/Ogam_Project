package com.go.ogamprj.controller.admin;

import com.go.ogamprj.mapper.DashboardMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Admin_DashboardController {
    @Autowired
    DashboardMapper dashboardMapper;

    @RequestMapping("/adminMain") // application root
    public String main(Model model) {
        model.addAttribute("users", dashboardMapper.users() + "명");
        model.addAttribute("removeUser", dashboardMapper.removeUser() + "명");
        model.addAttribute("diary", dashboardMapper.diary() + "개");
        model.addAttribute("reply", dashboardMapper.blackcnt().size() + "개");

        return "admin/main";
    }

    @RequestMapping("/emotion")
    @ResponseBody
    public List<EmotionStatus> emotionChart() {
        ArrayList<String> emotion = dashboardMapper.emotionList();
        ArrayList<Integer> cnt = dashboardMapper.cntList();
        String[] emoji = {"😭", "😄", "😡", "😔", "😥", "🥰"};
        List<EmotionStatus> map = new ArrayList<>();
        for (int i = 0; i < emotion.size(); i++) {
            map.add(EmotionStatus.builder().name(emotion.get(i) + emoji[i]).score(cnt.get(i)).build());
        }

        return map;
    }

    @RequestMapping("/diaryCnt")
    @ResponseBody
    public int diaryCnt() {
        int dCnt = dashboardMapper.diaryCnt();
        System.out.println(dCnt);
        return dCnt;
    }

    @RequestMapping("/memberCnt")
    @ResponseBody
    public int memberCnt() {
        int mCnt = dashboardMapper.memberCnt();
        System.out.println(mCnt);
        return mCnt;
    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class EmotionStatus {
    String name;
    Integer score;
}

