package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.dto.Board;
import com.go.ogamprj.mapper.AdminBoardMapper;
import com.go.ogamprj.sevice.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    AdminBoardMapper adminBoardMapper;

    @Override
    public void boardInsert(Board board) {
        adminBoardMapper.boardInsert(board);
    }

    @Override
    public void boardUpdate(Board board) {
        adminBoardMapper.boardUpdate(board);
    }

    @Override
    public void boardDelete(int board_seq) {
        adminBoardMapper.boardDelete(board_seq);
    }
}
