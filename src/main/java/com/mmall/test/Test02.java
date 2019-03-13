package com.mmall.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version : 1.0
 * @ClassName: Test02
 * @Description :
 * @auther: hejia
 * @date: 2018/12/19
 */
public class Test02 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Long> list=new ArrayList<Long>();
        list.add(Long.valueOf(1));
        list.add(Long.valueOf(1));
        list.add(Long.valueOf(2));
        list.add(Long.valueOf(2));
        list.add(Long.valueOf(2));
        list.add(Long.valueOf(3));
        list.add(Long.valueOf(3));

        //定义一个map来存放每个元素出现的次数
        Map<Long,Integer> elementsCount=new HashMap<Long,Integer>();
        //有编号查询
        /*
         * 循环判断
         */
        for(Long s:list){
            Integer i=elementsCount.get(s);
            if(i==null){
                elementsCount.put(s, 1);
            }else{
                elementsCount.put(s, i+1);
            }
        }
        System.out.println();
        //-----------
        //输出结果
        for(Long key:elementsCount.keySet()){
            System.out.println(key+"出现了 " +elementsCount.get(key) +"次");
        }
    }
}
