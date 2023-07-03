package com.example.mail.dto;


import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailDto {
    private String fromAddress; //내 이메일
    private String toUser; //받는 사람
    private String ccUser; //참조
    private String bccUser; //숨은 참조
    private String subject; //제목
    private String content; //내용
    private boolean isUseHtmlYn; //메일 형식이 HTML인지 여부
}
