package com.azurealstn.legacyspring.service;

import com.azurealstn.legacyspring.domain.BoardVO;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-servlet.xml")
@Log4j
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void testExist() {
        log.info(boardService);
        assertNotNull(boardService);
    }

    @Test
    public void testRegister() {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("새로 작성하는 글");
        boardVO.setContent("새로 작성하는 내용");
        boardVO.setWriter("newbie");

        boardService.register(boardVO);

        log.info("생성된 게시글 번호: " + boardVO.getBno());
    }

    @Test
    public void testGetList() {
        boardService.getList().forEach(board -> log.info(board));
    }

    @Test
    public void testGet() {
        log.info(boardService.get(5L));
    }

    @Test
    public void testUpdate() {
        BoardVO boardVO = boardService.get(5L);

        if (boardVO == null) {
            return;
        }

        boardVO.setTitle("제목 수정");
        log.info("수정 결과: " + boardService.modify(boardVO));
    }

    @Test
    public void testDelete() {
        log.info("삭제 결과: " + boardService.remove(10L));
    }
}
