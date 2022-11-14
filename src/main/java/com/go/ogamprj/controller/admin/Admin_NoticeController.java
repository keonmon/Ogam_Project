package com.go.ogamprj.controller.admin;

import com.go.ogamprj.dto.Board;
import com.go.ogamprj.sevice.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class Admin_NoticeController {
    @Autowired
    BoardService boardService;

    @RequestMapping("/admin_noticeList")
    public String admin_noticeList(HttpServletRequest request, String type, String keyword, Model model) {

        if ( keyword == null) {
            model.addAttribute("boards", boardService.adminBoardSelectAll());
        } else {
            model.addAttribute("boards", boardService.adminBoardSelectKeyword(type, "%"+ keyword + "%"));
        }

        return "admin/noticeList";
    }

    @RequestMapping("/writeNotice") // 공지 작성으로 가기
    public String writeNotice(HttpServletRequest request) {

        return "admin/board";
    }

    @RequestMapping("/addNotice") // 작성 완료하면 공지 리스트로 돌아가기
    public String addNotice(@RequestParam String board_title, @RequestParam String board_contents
                            , @RequestParam(defaultValue = "n") String board_yn) {
        Board board = new Board(board_title, board_contents, board_yn);

        boardService.boardInsert(board);
//        System.out.println(board);

        return "redirect:/admin_noticeList";
    }

//   해당 공지로 넘어가기
    @RequestMapping("/boardRevise/{board_seq}")
    public String goAdminUpdate(@PathVariable int board_seq, Model model) {

        Board findBoard = boardService.selectOneBoard(board_seq);

        model.addAttribute("board", findBoard);
        return "admin/boardRevise";
    }

//    공지사항 수정하기
    @RequestMapping("/adminUpdate")
    public String adminUpdate(@RequestParam String board_title, @RequestParam String board_contents
            , @RequestParam(defaultValue = "n") String board_yn, @RequestParam int board_seq) {

        Board board = new Board(board_title, board_contents, board_yn);
        board.setBoard_seq(board_seq);
//        System.out.println(board);

        boardService.boardUpdate(board);
        return "redirect:/admin_noticeList";
    }

//    공지사항 삭제하기
    @RequestMapping("/deleteNotice")
    public String deleteNotice(@RequestParam List<Integer> check) {
        if(check.size() > 0) {
            for(Integer num : check) boardService.boardDelete(num);
        }
        return "redirect:/admin_noticeList";
    }

}
