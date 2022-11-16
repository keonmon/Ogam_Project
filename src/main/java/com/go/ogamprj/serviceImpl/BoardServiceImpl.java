package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.dto.Board;
import com.go.ogamprj.mapper.AdminBoardMapper;
import com.go.ogamprj.sevice.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
    @Autowired
    AdminBoardMapper adminBoardMapper;

    @Override
    public ArrayList<Board> adminBoardSelectAll() {
        return adminBoardMapper.adminBoardSelectAll();
    }

    // 키워드 검색
    @Override
    public ArrayList<Board> adminBoardSelectKeyword(String type, String keyword) {
        return adminBoardMapper.adminBoardSelectKeyword(type, keyword);
    }

    // user 페이지에 공지 보여주기
    @Override
    public ArrayList<Board> selectAll() throws ParseException {
        return adminBoardMapper.selectAll();
    }

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

    @Override
    public Board selectOneBoard(int board_seq) {
        return adminBoardMapper.selectOneBoard(board_seq);
    }


}
