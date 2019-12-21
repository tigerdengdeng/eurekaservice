package com.tiger.projectcommon.common.httpcode;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 自定义返回编码/状态
 *
 * @author mytiger
 * @date 2019-21-16
 */
@Component
public enum code {
    PRIMARY_SCHOOL(100, "你可能在上小学"),
    MIDDLE_SCHOLL(101, "你可能在上中学"),
    ;

    private Integer code;
    private String message;

    code(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
