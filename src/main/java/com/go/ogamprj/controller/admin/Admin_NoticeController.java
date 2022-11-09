package com.go.ogamprj.controller.admin;

import com.go.ogamprj.dto.Board;
import com.go.ogamprj.serviceImpl.BoardServiceImpl;
import com.go.ogamprj.sevice.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Admin_NoticeController {
    @Autowired
    BoardService boardService;

    @RequestMapping("/admin_noticeList")
    public String admin_noticeList() {

        return "admin/noticeList";
    }

    @RequestMapping("/writeNotice") // 공지 작성으로 가기
    public String writeNotice(HttpServletRequest request) {

        return "admin/board";
    }

    @RequestMapping("/addNotice") // 작성 완료하면 공지 리스트로 돌아가기
    public String addNotice(@RequestParam String board_title, @RequestParam String board_contents, @RequestParam(defaultValue = "n") String board_yn) {
        Board board = new Board(board_title, board_contents, board_yn);

        boardService.boardInsert(board);
//        System.out.println(board);

        return "redirect:/admin_noticeList";
    }
}
