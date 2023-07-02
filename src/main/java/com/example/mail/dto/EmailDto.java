package com.example.mail.dto;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailDto {
    private String fromAddress; //내 이메일
    private String toUser; //받는 사람
    private String ccUser; //참조
    private String bccUser; //숨은 참조
    private String subject; //제목
    private String content; //내용
    private boolean isUseHtmlYn; //메일 형식이 HTML인지 여부

    @Builder
    public EmailDto(String fromAddress, String toUser, String ccUser, String bccUser, String subject, String content, boolean isUseHtmlYn) {
        this.fromAddress = fromAddress;
        this.toUser = toUser;
        this.ccUser = ccUser;
        this.bccUser = bccUser;
        this.subject = subject;
        this.content = content;
        this.isUseHtmlYn = isUseHtmlYn;
    }
}
