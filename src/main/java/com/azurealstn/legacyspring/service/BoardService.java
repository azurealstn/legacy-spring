package com.azurealstn.legacyspring.service;

import com.azurealstn.legacyspring.domain.BoardVO;

import java.util.List;

public interface BoardService {

    public void register(BoardVO boardVO);

    public BoardVO get(Long bno);

    public boolean modify(BoardVO boardVO);

    public boolean remove(Long bno);

    public List<BoardVO> getList();
}
