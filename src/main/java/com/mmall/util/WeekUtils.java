package com.mmall.util;


import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WeekUtils {

    /**
     * 获取某时间段内所有周的列表（开始时间，结束时间）
     * @param startDate
     * @param endDate
     * @return<![CDATA[]]>
     */
    public static List<String[]> getWeekList(Date startDate, Date endDate)throws Exception{
        List<String[]> weekList = new ArrayList<>();
        //转换成joda-time的对象
        DateTime firstDay = new DateTime(startDate).dayOfWeek().withMinimumValue();
        DateTime lastDay = new DateTime(endDate).dayOfWeek().withMaximumValue();
        //计算两日期间的区间天数
        Period p = new Period(firstDay, lastDay, PeriodType.days());
        int days = p.getDays();
        if (days > 0){
            int weekLength = 7;
            for(int i=0;i<days;i=i+weekLength){
                String monDay = firstDay.plusDays(i).toString("yyyy-MM-dd");
                String sunDay = firstDay.plusDays(i+6).toString("yyyy-MM-dd");
                String [] week = {monDay,sunDay};
                weekList.add(week);
            }
        }
        return weekList;
    }


    public static void main(String[] args) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = df.parse("2018-12-01");
        Date date2 = df.parse("2018-12-09");
        List<String[]> list = getWeekList(date1, date2);
//        for(int i= 0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
        System.out.println(getWeekList(date1,date2));
    }





}
