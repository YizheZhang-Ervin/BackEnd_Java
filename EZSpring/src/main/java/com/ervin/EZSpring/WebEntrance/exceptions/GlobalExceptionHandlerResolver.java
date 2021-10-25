package com.ervin.EZSpring.WebEntrance.exceptions;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

// 全局异常处理类
@ControllerAdvice  // 全局异常切面类+交给IOC容器维护

public class GlobalExceptionHandlerResolver {
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code",500);
        map.put("msg","error");
        // 特定异常处理-方法1:
//        if(e instanceof ParamsException){
//            ParamsException pe = (ParamsException)e;
//            map.put("code", pe.getCode());
//            map.put("msg", pe.getMsg());
//        }

        return map;
    }

    // 特定异常处理-方法2:
    @ExceptionHandler(value= ParamsException.class)
    @ResponseBody
    public Map<String,Object> paramsExceptionHandler(ParamsException pe){
        Map<String,Object> map = new HashMap<>();
        map.put("code",pe.getCode());
        map.put("msg",pe.getMsg());
        return map;
    }

    // 数据校验的异常
    @ExceptionHandler(value=BindException.class)
    @ResponseBody
    public Map<String,Object> bindExceptionHandler(BindException be){
        Map<String,Object> map = new HashMap<>();
        map.put("code",500);
        map.put("msg",be.getBindingResult().getFieldError().getDefaultMessage());
        return map;
    }
}

