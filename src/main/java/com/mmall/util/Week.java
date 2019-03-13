package com.mmall.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @version : 1.0
 * @ClassName: Week
 * @Description :
 * @auther: hejia
 * @date: 2018/12/10
 */
public class Week {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdw = new SimpleDateFormat("E");
        System.out.println("请输入时间段，格式如：20160101-20161111（不足10位以0补足）");
        Scanner s = new Scanner(System.in);
        String date = s.next();
        String begin_date = date.split("-")[0];
        String end_date = date.split("-")[1];
        String begin_date_fm = begin_date.substring(0, 4) + "-" + begin_date.substring(5,6) + "-" + begin_date.substring(7,8);
        String end_date_fm =  end_date.substring(0, 4) + "-" + end_date.substring(5,6) + "-" + end_date.substring(7,8);
        Date b = null;
        Date e = null;
        try {
            b = sd.parse(begin_date_fm);
            e = sd.parse(end_date_fm);
        } catch (ParseException ee) {
            ee.printStackTrace();
        }
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(b);
        Date time = b;
        String year = begin_date_fm.split("-")[0];
        String mon = Integer.parseInt(begin_date_fm.split("-")[1])<10?"0"+begin_date_fm.split("-")[1]:begin_date_fm.split("-")[1];
        String day = Integer.parseInt(begin_date_fm.split("-")[2])<10?"0"+begin_date_fm.split("-")[2]:begin_date_fm.split("-")[2];
        String timeb = year+mon+day;
        String timee = null;
        while(time.getTime()<=e.getTime()){
            rightNow.add(Calendar.DAY_OF_YEAR,1);
            time = sd.parse(sd.format(rightNow.getTime()));
            String timew = sdw.format(time);
            if(("星期一").equals(timew)){
                timeb = (sd.format(time)).replaceAll("-", "");
            }
            if(("星期日").equals(timew) || ("星期七").equals(timew) || time.getTime() == e.getTime()){
                timee = (sd.format(time)).replaceAll("-", "");
                System.out.println(timeb+"-"+timee);
            }
        }

    }


}
