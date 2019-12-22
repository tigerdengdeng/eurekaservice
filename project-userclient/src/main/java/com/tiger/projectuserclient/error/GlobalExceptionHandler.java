package com.tiger.projectuserclient.error;

import com.tiger.projectcommon.common.httpcode.code;
import com.tiger.projectcommon.common.json.JsonResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * 自定义全局返回异常类
 *
 * @author mytiger
 * @date 2019 12-22-22:59
 */
//全局异常类 注解
@ControllerAdvice
//以JSON格式返回
@ResponseBody
public class GlobalExceptionHandler {

    //添加全局异常处理流程，根据需要设置需要处理的异常，本文以MethodArgumentNotValidException为例
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public Object MethodArgumentNotValidHandler(HttpServletRequest request,
                                                MethodArgumentNotValidException exception) throws Exception
    {
        JsonResult resultMsg = new JsonResult(code.ERROR_401.getCode().toString(),exception.getBindingResult().getFieldError().getDefaultMessage());
        return resultMsg;
    }


}
