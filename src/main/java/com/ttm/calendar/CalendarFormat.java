package com.ttm.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Administrator on 2016/3/30.
 */
public class CalendarFormat {

    /**
     * 给定字符串时间，设置对应的格式输出
     * 1.获取一个上海时间 nowDate，格式化字符串时间 changeDate
     * 2.获取 nowDate的毫秒数，获取 changeDate的毫秒数
     * 3.nowDate - change 之差的时间 相隔时间 differenceDate
     * 4.根据 differenceDate 得到一个相差小时 differenceHour 根据 differenceHour 判断得到一个字符串
     * <li>EST - -05:00</li>
     * <li>HST - -10:00</li>
     * <li>MST - -07:00</li>
     * <li>ACT - Australia/Darwin</li>
     * <li>AET - Australia/Sydney</li>
     * <li>AGT - America/Argentina/Buenos_Aires</li>
     * <li>ART - Africa/Cairo</li>
     * <li>AST - America/Anchorage</li>
     * <li>BET - America/Sao_Paulo</li>
     * <li>BST - Asia/Dhaka</li>
     * <li>CAT - Africa/Harare</li>
     * <li>CNT - America/St_Johns</li>
     * <li>CST - America/Chicago</li>
     * <li>CTT - Asia/Shanghai</li>
     * <li>EAT - Africa/Addis_Ababa</li>
     * <li>ECT - Europe/Paris</li>
     * <li>IET - America/Indiana/Indianapolis</li>
     * <li>IST - Asia/Kolkata</li>
     * <li>JST - Asia/Tokyo</li>
     * <li>MIT - Pacific/Apia</li>
     * <li>NET - Asia/Yerevan</li>
     * <li>NST - Pacific/Auckland</li>
     * <li>PLT - Asia/Karachi</li>
     * <li>PNT - America/Phoenix</li>
     * <li>PRT - America/Puerto_Rico</li>
     * <li>PST - America/Los_Angeles</li>
     * <li>SST - Pacific/Guadalcanal</li>
     * <li>VST - Asia/Ho_Chi_Minh</li>
     *
     * @return 想要格式的字符串
     */
    public String format(String stringDate) {
        TimeZone zone = TimeZone.getTimeZone("Asia/Shanghai");
        Calendar nowCalendar = Calendar.getInstance(zone);
        System.out.println("获取 " + zone.getID() + ": " +
                nowCalendar.get(Calendar.YEAR) +
                "-" + (nowCalendar.get(Calendar.MONTH) + 1) +
                "-" + nowCalendar.get(Calendar.DAY_OF_MONTH) +
                " " + nowCalendar.get(Calendar.ZONE_OFFSET));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date changeDate = null;
        try {
            changeDate = format.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar changeCalendar = Calendar.getInstance();
        changeCalendar.setTime(changeDate);
        System.out.println("获取 " + zone.getID() + ": " +
                changeCalendar.get(Calendar.YEAR) +
                "-" + (changeCalendar.get(Calendar.MONTH) + 1) +
                "-" + changeCalendar.get(Calendar.DAY_OF_MONTH) +
                " " + changeCalendar.get(Calendar.HOUR_OF_DAY) + " " + changeCalendar.get(Calendar.DAY_OF_YEAR));

        return null;
    }

    public static void main(String[] args) {
        String strDate = "2015-02-1 08:00:00";
        CalendarFormat format = new CalendarFormat();
        format.format(strDate);

    }

}
