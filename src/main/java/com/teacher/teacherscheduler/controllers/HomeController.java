package com.teacher.teacherscheduler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;

@Controller
class HelloController {

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Tracker");
        return "home/home-page";
    }
}

