package com.example.mail.controller;

import com.example.mail.dto.EmailDto;
import com.example.mail.service.EmailService;
import com.example.mail.util.EmailEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class EmailController {

    @Resource
    private EmailService emailService;

    /**
     * 메일 보내기
     * @param mav
     * @param request
     * @param result
     * @return
     */
    @PostMapping("/mailSend")
    public ModelAndView mailSendPost(ModelAndView mav, HttpServletRequest request, BindingResult result) {
        String code = "0000";

        //1. 요청값 검증
        if(result.hasErrors()) {
            log.error("요청값 에러 {}", result.getTarget());
            code = "0001";
        }

        EmailDto emailDto = EmailDto.builder()
                .toUser(request.getParameter("toUser"))
                .ccUser(request.getParameter("ccUser"))
                .bccUser(request.getParameter("bccUser"))
                .fromAddress(request.getParameter("fromAddress"))
                .subject(request.getParameter("subject"))
                .content(request.getParameter("content"))
                .build();

        //2. 메일 전송
        code = emailService.sendMailSimple(emailDto);

        //3, 결과 반환
        mav.addObject("code", code);
        mav.addObject("msg", EmailEnum.getMessage(code));
        mav.setViewName("callBack");
        return mav;
    }
}
