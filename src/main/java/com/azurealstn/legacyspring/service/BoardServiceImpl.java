package com.azurealstn.legacyspring.service;

import com.azurealstn.legacyspring.domain.BoardVO;
import com.azurealstn.legacyspring.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public void register(BoardVO boardVO) {
        log.info("register...." + boardVO);
        boardMapper.insertSelectKey(boardVO);
    }

    @Override
    public BoardVO get(Long bno) {
        log.info("get........." + bno);
        return boardMapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO boardVO) {
        log.info("modify........" + boardVO);
        return boardMapper.update(boardVO) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        log.info("remove......" + bno);
        return boardMapper.delete(bno) == 1;
    }

    @Override
    public List<BoardVO> getList() {
        log.info("getList...........");
        return boardMapper.getList();
    }
}
