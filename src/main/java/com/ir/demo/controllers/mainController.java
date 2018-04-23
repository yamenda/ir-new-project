package com.ir.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test")
public class mainController {

    @RequestMapping( value = "" , method = RequestMethod.GET)
    public String test(Model model) {
        return "test";
    }

}
