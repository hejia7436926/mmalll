package com.mmall.test;

import java.util.ArrayList;

/**
 * @version : 1.0
 * @ClassName: ListTest
 * @Description :
 * @auther: hejia
 * @date: 2018/12/18
 */
public class ListTest {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 10;
        Integer e = 7;
        integers.add(a);
        integers.add(b);
        integers.add(c);
        integers.add(d);
        integers.add(e);
        System.out.println(String.valueOf(integers));
    }
}
