package com.go.ogamprj.controller.user;

import com.go.ogamprj.dto.Board;
import com.go.ogamprj.sevice.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class User_NoticeController {

    @Autowired
    BoardService boardService;

    @RequestMapping("/board")
    public String notice(Model model) throws ParseException {
        List<Board> result = boardService.selectAll();
        model.addAttribute("boards", result);
        System.out.println();

        List<String> boardDate = new ArrayList<>();

        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("yy. MM. dd. EEE", Locale.ENGLISH);

        for( int i = 0; i < result.size(); i++){

            date = result.get(i).getBoard_date();
            String formatedDate = sdf.format(date);
            boardDate.add(formatedDate);
        }

        System.out.println(boardDate);
        model.addAttribute("boardDate", boardDate);
        return "user/noticePage/board";
    }
}
