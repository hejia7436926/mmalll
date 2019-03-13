package com.mmall.util;


import org.apache.commons.io.filefilter.FalseFileFilter;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 两个时间值的差值周的工具类
 */
public class DateWeekUtils {

    public static Long diffWeeks(Date date1, Date date2) throws Exception {
        Long weeks = (date1.getTime() - date2.getTime() + 24 * 60 * 60 * 1000) / (7 * 24 * 60 * 60 * 1000);
        return weeks;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = df.parse("2018-12-16");
        Date date2 = df.parse("2018-12-03");
        Long wee = DateWeekUtils.diffWeeks(date1, date2);
        System.out.println(wee);

    }

    public List<Map<Date,Date>> dates(Date date1,Date date2)throws Exception{
        ArrayList<Map<Date, Date>> lists = new ArrayList<>();
        HashMap<Date, Date> maps = new HashMap<>();
        if(date1.before(date2)){//date1<date2，然后把时间拆分为以周为单位的集合
            Long weeks = (date1.getTime() - date2.getTime() + 24 * 60 * 60 * 1000) / (7 * 24 * 60 * 60 * 1000);//周数
            for(int i = 0; i<weeks;i++){//几周就转化为几条数据，例：2018-12-03  2018-12-16
//                maps.put(date1,(date2.getTime()+7 * 24 * 60 * 60 * 1000).)
//                Date put = maps.put(date1,date1.getTime()+24*60*60*1000*6);
                lists.add(maps);
            }

        }

        return lists;
    }

}
