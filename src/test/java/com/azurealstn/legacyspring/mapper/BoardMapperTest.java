package com.azurealstn.legacyspring.mapper;

import com.azurealstn.legacyspring.domain.BoardVO;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-servlet.xml")
@Log4j
public class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testGetList() {
        boardMapper.getList().forEach(board -> log.info(board));
    }

    @Test
    public void testInsert() {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("Test 제목");
        boardVO.setContent("Test 내용");
        boardVO.setWriter("Test 저자");

        boardMapper.insert(boardVO);
        log.info(boardVO);
    }

    @Test
    public void testInsertSelectKey() {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("Test 제목 selectKey");
        boardVO.setContent("Test 내용 selectKey");
        boardVO.setWriter("Test 저자 selectKey");

        boardMapper.insertSelectKey(boardVO);

        log.info(boardVO);
    }

    @Test
    public void testRead() {
        BoardVO boardVO = boardMapper.read(5L);
        log.info(boardVO);
    }

    @Test
    public void testDelete() {
        log.info(boardMapper.delete(19L));
    }

    @Test
    public void testUpdate() {
        BoardVO boardVO = new BoardVO();
        boardVO.setBno(5L);
        boardVO.setTitle("수정3 제목");
        boardVO.setContent("수정3 내용");
        boardVO.setWriter("user01");

        int count = boardMapper.update(boardVO);
        log.info(count);
    }
}
