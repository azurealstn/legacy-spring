package com.azurealstn.legacyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("test", "1234");
        return "index";
    }
}
