package com.azurealstn.legacyspring.controller;

import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-servlet.xml")
@Log4j
public class BoardControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mvc;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testList() throws Exception {
        log.info(
                mvc.perform(MockMvcRequestBuilders.get("/board/list"))
                        .andReturn()
                        .getModelAndView()
                        .getModelMap());
    }

    @Test
    public void testRegister() throws Exception {
        String resultPage =
                mvc.perform(MockMvcRequestBuilders
                        .post("/board/register")
                        .param("title", "테스트 제목")
                        .param("content", "테스트 내용")
                        .param("writer", "테스트 저자")
                ).andReturn().getModelAndView().getViewName();

        log.info(resultPage);
    }

    @Test
    public void testGet() throws Exception {
        log.info(mvc.perform(MockMvcRequestBuilders
                .get("/board/get")
                .param("bno", "8"))
                .andReturn()
                .getModelAndView().getModelMap());
    }

    @Test
    public void testModify() throws Exception {
        String resultPage = mvc
                .perform(MockMvcRequestBuilders.post("/board/modify")
                        .param("bno", "5")
                        .param("title", "수정된 테스트 새글 제목")
                        .param("content", "수정된 테스트 내용")
                        .param("writer", "수정된 테스트 저자"))
                .andReturn().getModelAndView().getViewName();

        log.info(resultPage);
    }

    @Test
    public void testRemove() throws Exception {
        String resultPage = mvc
                .perform(MockMvcRequestBuilders.post("/board/remove")
                        .param("bno", "11"))
                .andReturn().getModelAndView().getViewName();

        log.info(resultPage);
    }
}
