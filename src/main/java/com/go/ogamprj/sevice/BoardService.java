package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Board;

import java.text.ParseException;
import java.util.ArrayList;

public interface BoardService {

    ArrayList<Board> adminBoardSelectAll();

    ArrayList<Board> adminBoardSelectKeyword(String type, String keyword);      // 키워드 검색

    ArrayList<Board> selectAll() throws ParseException;

    void boardInsert(Board board);

    void boardUpdate(Board board);

    void boardDelete(int board_seq);

    Board selectOneBoard(int board_seq);


}
