package com.example.mail.util;

import lombok.Getter;

@Getter
public enum EmailEnum {
    API_0000("0000", "정상처리되었습니다."),
    API_0001("0001", "요청값 오류"),
    API_0002("0002", "시스템 오류");

    private String code;
    private String msg;
    EmailEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * msg 반환
     */
    public static String getMessage(String code) {
        for(EmailEnum emailEnum : values()) {
            if(emailEnum.getCode().equals(code)) {
                return emailEnum.getMsg();
            }
        }
        return "잘못된 코드입니다.";
    }
}
