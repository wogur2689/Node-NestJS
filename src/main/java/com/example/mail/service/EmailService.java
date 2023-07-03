package com.example.mail.service;

import com.example.mail.dto.EmailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    /**
     * @info : 지정된 주소로 이메일 전송
     * @param : emailDTO
     * @throws : Exception
     * @Description : 이메일주소, 내용, 제목 필수
     */
    @Async
    public String sendMailSimple(EmailDto emailDto) {
        String code = "0000";
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(emailDto.getToUser());
        simpleMailMessage.setSubject(emailDto.getSubject());
        simpleMailMessage.setFrom(emailDto.getFromAddress());
        simpleMailMessage.setText(emailDto.getContent());

        try {
            mailSender.send(simpleMailMessage);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("메일 전송 오류 : {} ", e.getMessage());
            code = "0002";
        }
        return code;
    }

    /**
     * @info : 지정된 주소로 이메일 전송(내용이 html형식인 경우)
     * @param : emailDTO
     * @throws : Exception
     * @Description : 이메일주소, 내용, 제목 필수
     */
    @Async
    public String sendMailMime(EmailDto emailDto) {
        String code = "0000";
        MimeMessage message = mailSender.createMimeMessage();

        try {
            message.setSubject(emailDto.getSubject());
            message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(emailDto.getToUser(), "", "UTF-8")));
            message.setText(emailDto.getContent(), "UTF-8", "html");

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("메일 전송 오류 : {} ", e.getMessage());
            code = "0002";
        }
        return code;
    }
}
