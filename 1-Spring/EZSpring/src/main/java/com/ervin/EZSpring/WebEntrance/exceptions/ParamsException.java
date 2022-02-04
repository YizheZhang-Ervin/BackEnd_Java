package com.ervin.EZSpring.WebEntrance.exceptions;

public class ParamsException extends RuntimeException{
    Integer code =500;
    String msg = "parameter exception";

    public ParamsException(){
        super("parameter exception");
    }

    public ParamsException(String msg){
        super(msg);
        this.msg = msg;
    }

    public ParamsException(Integer code){
        super("parameter exception");
        this.code = code;
    }
    public ParamsException(Integer code, String msg){
        super("parameter exception");
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
