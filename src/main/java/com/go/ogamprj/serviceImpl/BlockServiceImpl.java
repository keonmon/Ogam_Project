package com.go.ogamprj.serviceImpl;

import com.go.ogamprj.dto.Block;
import com.go.ogamprj.dto.Board;
import com.go.ogamprj.mapper.BlockMapper;
import com.go.ogamprj.sevice.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    BlockMapper blockMapper;

    @Override
    public List<HashMap<String, Object>> blockList(String member_email) {
        return blockMapper.blockList(member_email);
    }

    @Override
    public void blockDel(int block_seq) {
        blockMapper.blockDel(block_seq);
    }

    @Override
    public void blockPlus(Block block) {
        blockMapper.blockPlus(block);
    }

    public int doubleBlock(Block block) {
        return blockMapper.doubleBlock(block);
    }

    @Override
    public String findId(String member_nick) {
        return blockMapper.findId(member_nick);
    }

}
