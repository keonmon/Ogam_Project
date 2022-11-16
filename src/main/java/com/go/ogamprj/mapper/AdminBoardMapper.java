package com.go.ogamprj.mapper;

import com.go.ogamprj.dto.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface AdminBoardMapper {

    @Select("SELECT * FROM BOARD")
    public ArrayList<Board> adminBoardSelectAll();  // 관리자 페이지 boardList (공개 비공개 다 보임)

    ArrayList<Board> adminBoardSelectKeyword(String type, String keyword);  // 키워드 검색

    @Select("select * from board where board_yn = 'y' order by BOARD_DATE desc")
    public ArrayList<Board> selectAll();

    public void boardInsert(Board board);

    public void boardUpdate(Board board);

    public void boardDelete(int board_seq);

    @Select("SELECT * FROM BOARD WHERE BOARD_SEQ = #{board_seq}")
    public Board selectOneBoard(int board_seq);


}
