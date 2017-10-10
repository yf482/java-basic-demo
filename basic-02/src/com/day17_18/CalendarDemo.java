package com.day17_18;

import java.util.Calendar;

/**
 * 两个联系：
 * 1.获取任意年的二月份都多少天
 * c.set(year,3,1);
 * c.add(Calendar.DAY_OF_MONTH,-1);
 * 2.获取该时刻的上个星期的的时间
 * c.add(Calendar.DAY_OF_WEEK,-1);
 *
 * @author YF482
 */
public class CalendarDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Calendar c = Calendar.getInstance();
        String[] months = {"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月",};
        String[] weeks = {"", "星期日", "星期1", "星期2", "星期3", "星期4", "星期5", "星期6",};
//		System.out.println(c);
        System.out.println(c.get(Calendar.YEAR) + "年");
        System.out.println(c.get(Calendar.MONTH) + "月");
        System.out.println(months[c.get(Calendar.MONTH)]);
        System.out.println(c.get(Calendar.DAY_OF_MONTH) + "日");
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(weeks[c.get(Calendar.DAY_OF_WEEK)]);

        c.set(2012, 2, 3);
        c.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(c.getTime());

    }

}
