package com.mmall.common;

public enum  ResponseCode {
    SUCCESS(0,"SUCCESS"),//成功登陆
    ERROR(1,"ERROR"),    //错误
    NEED_LOGIN(10,"NEED_LOGIN"),//需要登陆
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");//参数错误

    private final int code;
    private final String desc;//排序的方式


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
}
