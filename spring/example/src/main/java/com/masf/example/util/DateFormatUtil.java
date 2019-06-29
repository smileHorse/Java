package com.masf.example.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Date formatStr2Date(String str) {
        return dateFormat.parse(str, new ParsePosition(0));
    }

    public static int getBetweenDays(Date sd, Date ed) {
        long diff = ed.getTime() - sd.getTime();
        return (int)(diff / (1000 * 3600 * 24));
    }
}
