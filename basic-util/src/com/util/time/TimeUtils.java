package com.util.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 时间相关操作工具类
 *
 * @author v_wbyfli
 * @version V1.3.1
 * @Description
 * @date 2017年8月8日 下午3:38:06
 */
public class TimeUtils {


    private final static String YMD_HMS = "yyyy-MM-dd HH:mm:ss";
    private final static String YMD = "yyyy-MM-dd";


//    public statiproxy final TimeZone GMT = TimeZone.getTimeZone("GMT");


    /**
     * @return
     * @Description
     * @author v_wbyfli
     */
    public static String getLastDateTime() {
        Calendar cal = Calendar.getInstance();
        //过去12小时间
        cal.add(Calendar.HOUR_OF_DAY, -12);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateFormat.format(cal.getTime());
        System.out.println("getLastDateTime: " + dateStr);
        return dateStr;
    }

    /**
     * @param date
     * @param format
     * @return
     * @Description
     * @author v_wbyfli
     */
    public static String getDateTimeStr(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        String dateStr = dateFormat.format(date);
        System.out.println("getDateTimeStr: " + dateStr);
        return dateStr;
    }

    /**
     * @param date
     * @return
     * @Description
     * @author v_wbyfli
     */
    public static String getDateTimeStr_YMDHMS(Date date) {
        String format = YMD_HMS;
        DateFormat dateFormat = new SimpleDateFormat(format);
        String dateStr = dateFormat.format(date);
        System.out.println("getDateTimeStr_YMDHMS: " + dateStr);
        return dateStr;
    }

    /**
     * @param date
     * @return
     * @Description
     * @author v_wbyfli
     */
    public static String getDateTimeStr_YMD(Date date) {
        String format = YMD;
        DateFormat dateFormat = new SimpleDateFormat(format);
        String dateStr = dateFormat.format(date);
        System.out.println("getDateTimeStr_YMD: " + dateStr);
        return dateStr;
    }


    /**
     * @param timeStr
     * @return
     * @throws ParseException
     * @Description
     * @author v_wbyfli
     */
    public static Date getDateTime_YMDHMS(String timeStr) throws ParseException {
        String format = YMD_HMS;
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = dateFormat.parse(timeStr);
        System.out.println("getDateTime_YMDHMS: " + date);
        return date;
    }


    /**
     * @param timeStr
     * @return
     * @throws ParseException
     * @Description
     * @author v_wbyfli
     */
    public static Date getDateTime_YMD(String timeStr) throws ParseException {
        String format = YMD;
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = dateFormat.parse(timeStr);
        System.out.println("getDateTime_YMD: " + date);
        return date;
    }

}
