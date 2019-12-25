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

    ERROR_400(400, "'请求错误'"),
    ERROR_401(401, "'未授权，请登录'"),
    ERROR_403(403, "'拒绝访问'"),
    ERROR_404(404, "'请求地址出错'"),
    ERROR_408(408, "'请求超时'"),

    ERROR_500(500, "'服务器内部错误'"),
    ERROR_501(401, "'服务未实现"),
    ERROR_502(502, "网关错误"),
    ERROR_503(503, "'服务不可用'"),
    ERROR_504(506, "网关超时"),
    ERROR_505(505, "HTTP版本不受支持"),

    ERROR_601(601, "无此用户"),
    ERROR_602(602, "密码错误"),

    SUCCESS_200(200, "操作成功"),
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
