package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Board;

public interface BoardService {

    void boardInsert(Board board);

    void boardUpdate(Board board);

    void boardDelete(int board_seq);

}
