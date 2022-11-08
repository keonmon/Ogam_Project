package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface AdminBoardMapper {

    @Select("SELECT * FROM BOARD")
    ArrayList<Board> adminBoardSelectAll();  // 관리자 페이지 boardList (공개 비공개 다 보임)

    void boardInsert(Board board);

    void boardUpdate(Board board);

    void boardDelete(int board_seq);

    @Select("SELECT * FROM BOARD WHERE BOARD_SEQ = #{BOARD_SEQ}")
    Board selectOneBoard(int board_seq);

}
