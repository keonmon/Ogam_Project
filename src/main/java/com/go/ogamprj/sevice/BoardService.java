package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Board;

import java.util.ArrayList;

public interface BoardService {

    ArrayList<Board> selectAll();

    void boardInsert(Board board);

    void boardUpdate(Board board);

    void boardDelete(int board_seq);

}
