package com.example.mail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageControlle {
    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/callBack")
    public ModelAndView callBack(ModelAndView mav) {
        mav.setViewName("callBack");
        return mav;
    }
}
