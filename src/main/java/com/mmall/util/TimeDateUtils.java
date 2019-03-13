package com.mmall.util;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeDateUtils {
    private static List<DateUtil> getWeeks(String begins, String ends) throws ParseException {
        ArrayList<DateUtil> dateUtils = new ArrayList<>();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdw = new SimpleDateFormat("E");
        String begin_date =begins;
        String end_date =ends;

        String begin_date_fm =  begins;
        String end_date_fm = ends;
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
        String mon = Integer.parseInt(begin_date_fm.split("-")[1])<10?begin_date_fm.split("-")[1]:begin_date_fm.split("-")[1];
        String day = Integer.parseInt(begin_date_fm.split("-")[2])<10?begin_date_fm.split("-")[2]:begin_date_fm.split("-")[2];
        String timeb = year+mon+day;
        String timee = null;
        if(begin_date==end_date){
            System.out.println(begin_date+"~"+end_date);
        }else{
            DateUtil dateUtil = new DateUtil();
            while(time.getTime()<=e.getTime()){
                rightNow.add(Calendar.DAY_OF_YEAR,1);
                time = sd.parse(sd.format(rightNow.getTime()));
                if(time.getTime()>e.getTime()){break;}
                String timew = sdw.format(time);
                if(("星期一").equals(timew)){
                    timeb = (sd.format(time)).replaceAll("-", "");
                }
                if(("星期日").equals(timew) || ("星期七").equals(timew) || time.getTime() == e.getTime()){
                    SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat sdw1 = new SimpleDateFormat("E");
                    timee = (sd.format(time)).replaceAll("-", "");
                    String begindate=fomaToDatas(timeb);
                    String enddate=fomaToDatas(timee);
//                    System.out.println(sd1.parse(begindate)+","+sd1.parse(enddate));
                    dateUtil.setBeginTime(sd1.parse(begindate));
                    dateUtil.setEndTime(sd1.parse(enddate));
                    dateUtils.add(dateUtil);
                }
            }

        }
        for(int i = 0;i<dateUtils.size();i++){
//            System.out.println(dateUtils.get(0));
        }
//        System.out.println(dateUtils);
        return dateUtils;
    }

    public static String fomaToDatas(String data){
        DateFormat fmt=new SimpleDateFormat("yyyyMMdd");
        try {
            Date parse=fmt.parse(data);
            DateFormat fmt2=new SimpleDateFormat("yyyy-MM-dd");
            return fmt2.format(parse);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String args[]) throws ParseException {
        ArrayList<Map<Date, Date>> maps = new ArrayList<>();
        String str_begin = "2018-11-18";
        String str_end = "2018-12-30";
        List<DateUtil> weeks = getWeeks(str_begin, str_end);
        System.out.println(weeks);
//        List<DateUtil> weeks = getWeeks(str_begin, str_end);
//        for(int i =0;i<weeks.size();i++){
//            DateFormat fmt=new SimpleDateFormat("yyyyMMdd");
//            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
//            DateUtil dateUtil = weeks.get(i);
//            if(dateUtil != null){//有数据
//                HashMap<Date, Date> map = new HashMap<>();
//                Date startTime = fmt.parse(dateUtil.getBeginTime());
//                Date endTime = fmt.parse(dateUtil.getEndTime());
//                map.put(startTime,endTime);
//                maps.add(map);
//            }
//        }
//        System.out.println(maps);

    }
                                                //2018-11-18    2018-12-30
    private static List<DateUtil> getWeeks1(String begins, String ends) throws ParseException {
        ArrayList<DateUtil> dateUtils = new ArrayList<>();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdw = new SimpleDateFormat("E");
        String begin_date =begins;
        String end_date =ends;

        String begin_date_fm =  begins;
        String end_date_fm = ends;
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
        String mon = Integer.parseInt(begin_date_fm.split("-")[1])<10?begin_date_fm.split("-")[1]:begin_date_fm.split("-")[1];
        String day = Integer.parseInt(begin_date_fm.split("-")[2])<10?begin_date_fm.split("-")[2]:begin_date_fm.split("-")[2];
        String timeb = year+mon+day;
        String timee = null;
        if(begin_date==end_date){
            System.out.println(begin_date+"~"+end_date);
        }else{
            DateUtil dateUtil = new DateUtil();
            while(time.getTime()<=e.getTime()){
                rightNow.add(Calendar.DAY_OF_YEAR,1);
                time = sd.parse(sd.format(rightNow.getTime()));
                if(time.getTime()>e.getTime()){break;}
                String timew = sdw.format(time);
                if(("星期一").equals(timew)){
                    timeb = (sd.format(time)).replaceAll("-", "");
                }
                if(("星期日").equals(timew) || ("星期七").equals(timew) || time.getTime() == e.getTime()){
                    SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat sdw1 = new SimpleDateFormat("E");
                    timee = (sd.format(time)).replaceAll("-", "");
                    String begindate=fomaToDatas(timeb);
                    String enddate=fomaToDatas(timee);
//                    System.out.println(sd1.parse(begindate)+","+sd1.parse(enddate));
                    dateUtil.setBeginTime(sd1.parse(begindate));
                    dateUtil.setEndTime(sd1.parse(enddate));
                    dateUtils.add(dateUtil);
                }
            }

        }
        for(int i = 0;i<dateUtils.size();i++){
//            System.out.println(dateUtils.get(0));
        }
//        System.out.println(dateUtils);
        return dateUtils;
    }

    @Test
    public void test() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("2019-01-17");
        System.out.println(sdf.format(date));
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
        sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
