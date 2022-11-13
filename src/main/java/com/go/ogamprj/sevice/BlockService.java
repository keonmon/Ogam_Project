package com.go.ogamprj.sevice;

import com.go.ogamprj.dto.Block;
import com.go.ogamprj.dto.Board;

import java.util.HashMap;
import java.util.List;

public interface BlockService {

    public List<HashMap<String, Object>> blockList(String member_email);

    public void blockDel(int block_seq);

    public void blockPlus(Block block);

    public int doubleBlock(Block block);

    public String findId(String member_nick);

}
