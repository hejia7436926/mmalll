package com.mmall.util;


import com.mmall.vo.DateVo;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 可用
 */
public class Week2 {
        //把一个时间段拆分为每一周展示的数组
        private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        public static   List<String[]> getType(Date sd , Date ed){
            long days = (ed.getTime() - sd.getTime()) / 3600 / 24 / 1000;//总的天数

            Calendar instance = Calendar.getInstance();
            instance.setTime(sd);
            int i = instance.get(Calendar.DAY_OF_WEEK);
            int fsi = 7 - i + 4;//修改一周的起始位置（周四为开始）
            long iiv = days - fsi;

            //天数
            long d = iiv / 7;

            instance.add(Calendar.DAY_OF_YEAR, fsi);

            List<String[]> list = new ArrayList<>();
            list.add(new String[]{df.format(sd), df.format(instance.getTime())});

            String[] ne ;
            for (long k = 0; k < d; k++) {
                instance.add(Calendar.DAY_OF_YEAR, 1);
                Date start = instance.getTime();
                instance.add(Calendar.DAY_OF_YEAR, 6);
                Date end = instance.getTime();
                ne = new String[]{df.format(start), df.format(end)};
                list.add(ne);
            }

            instance.add(Calendar.DAY_OF_YEAR, 1);
            if(instance.getTime().before(ed)){
                list.add(new String[]{df.format(instance.getTime()), df.format(ed)});
            }
            return list;
        }

    public static void main(String[] args) throws Exception {
//        List<String[]> type = getType(df.parse("2015-01-01"), df.parse("2017-06-15"));
        List<String[]>type = Week2.getType(df.parse("2018-12-01"), df.parse("2018-12-19"));
        ArrayList<DateVo> dateVos = new ArrayList<>();
        Integer count = 0;
        for (int i = 0; i < type.size(); i++) {
            if(i != 0 && i != type.size()){
                System.out.print(",");
            }
            DateVo dateVo = new DateVo();
            dateVo.setStr(type.get(i));
            dateVo.setNum(2);
            dateVos.add(dateVo);
            System.out.println(Arrays.toString(type.get(i)));
        }
        System.out.println("..........");
        for(int i = 0;i<dateVos.size();i++){
            Integer x = dateVos.get(i).getNum();
            count += x;//剩余组数总共的
        }
        System.out.println(dateVos);
        System.out.println(count);
    }
        @Test
        public void test(){
            HashSet<String> strings = new HashSet<>();
            strings.add("1");
            strings.add("2");
            if(strings.size()>0 && strings != null){
                for(String string : strings){
                    System.out.println(string);
                }
            }
        }

}
