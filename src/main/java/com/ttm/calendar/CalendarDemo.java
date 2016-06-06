package com.ttm.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/3/30.
 */
public class CalendarDemo {

    public static void main(String[] args) {
        String strDate = "2015-03-30 00:00:00";
        Calendar calendar = Calendar.getInstance();
        System.out.println("^^^^^^^^^^" + calendar.toString());

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date());
        System.out.println("^^^^^^^^^^" + calendar1.toString());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(strDate);
            LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.of("America/Los_Angeles")).toLocalDateTime();
            date = format.parse(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        System.out.println("^^^^^^^^^^" + calendar2.toString());
        System.out.println("^^^^^^^^^^^^^^^^" + calendar2.get(Calendar.YEAR));
        System.out.println("^^^^^^^^^^^^^^^^" + (calendar2.get(Calendar.MONTH) + 1));
        System.out.println("^^^^^^^^^^^^^^^^" + calendar2.get(Calendar.DAY_OF_MONTH));
    }

}
