package com.mmall.util;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 浮点型的加减乘除
 */
public class BigDecimalUtil {

    private BigDecimalUtil(){

    }
    //转化为String类型是为了防止丢失精度
    public static BigDecimal add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.add(b2);
    }

    public static BigDecimal sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.subtract(b2);
    }


    public static BigDecimal mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.multiply(b2);
    }

    public static BigDecimal div(double v1,double v2){
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);//四舍五入,保留2位小数
    }

    public static void main(String[] args) throws Exception{
        BigDecimal add = BigDecimalUtil.mul(21.5, 20.73);
//        System.out.println(add);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str ="1509548532000";
        Date date = sdf.parse(str);
        System.out.println(date);
    }
}
