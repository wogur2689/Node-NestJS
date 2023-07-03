package com.example.mail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageControlle {
    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index.html");
        return mav;
    }
}
