package com.lee.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 将Date转换成String
     * @param date
     * @return
     */
    public static String date2String(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * 将Timestamp转换成String
     * 用于数据库中字段类型为datetime
     * @param timestamp
     * @return
     */
    public static String time2String(Timestamp timestamp) {
        Date date = new Date(timestamp.getTime());
        String dateStr = date2String(date);
        return dateStr;
    }
}
