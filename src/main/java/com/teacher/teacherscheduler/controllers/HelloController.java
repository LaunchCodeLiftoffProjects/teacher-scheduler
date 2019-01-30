package com.teacher.teacherscheduler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index() {
        return "Hello World";
    }
//Classroom number, Teacher//
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewPeriod(Model model) {

        return "viewPeriod";
    }
}
