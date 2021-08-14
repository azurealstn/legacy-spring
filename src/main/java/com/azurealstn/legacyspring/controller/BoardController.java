package com.azurealstn.legacyspring.controller;

import com.azurealstn.legacyspring.domain.BoardVO;
import com.azurealstn.legacyspring.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/board/*")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
        model.addAttribute("list", boardService.getList());
    }

    @PostMapping("/register")
    public String register(BoardVO boardVO, RedirectAttributes attributes) {
        log.info("register: " + boardVO);
        boardService.register(boardVO);
        attributes.addFlashAttribute("result", boardVO.getBno());
        return "redirect:/board/list";
    }

    @GetMapping("/get")
    public void get(@RequestParam("bno") Long bno, Model model) {
        log.info("/get");
        model.addAttribute("board", boardService.get(bno));
    }

    @PostMapping("/modify")
    public String modify(BoardVO boardVO, RedirectAttributes attributes) {
        log.info("modify: " + boardVO);

        if (boardService.modify(boardVO)) {
            attributes.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, RedirectAttributes attributes) {
        log.info("remove: " + bno);

        if (boardService.remove(bno)) {
            attributes.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }
}
