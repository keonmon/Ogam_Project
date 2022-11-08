package com.go.ogamprj.controller.user;

import com.go.ogamprj.sevice.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class User_NoticeController {

    @Autowired
    BoardService boardService;

    @RequestMapping("/board")
    public String notice(Model model) {

        model.addAttribute("boards", boardService.selectAll());
        System.out.println(boardService.selectAll());
        return "user/noticePage/board";
    }
}
