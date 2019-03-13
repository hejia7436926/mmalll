package com.mmall.vo;

import java.util.Arrays;

/**
 * @version : 1.0
 * @ClassName: DateVo
 * @Description :
 * @auther: hejia
 * @date: 2018/12/12
 */
public class DateVo {

    private String[] str;//每周日期
    private Integer num;//每周剩余设备数

    public String[] getStr() {
        return str;
    }

    public void setStr(String[] str) {
        this.str = str;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "DateVo{" +
                "str=" + Arrays.toString(str) +
                ", num=" + num +
                '}';
    }
}
