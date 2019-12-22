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
    ERROR_500(500, "内部错误"),
    ERROR_401(401, "数据异常"),
    ERROR_404(404,"找不到页面"),
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
