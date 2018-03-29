package Util;

import java.text.NumberFormat;

public class FunUtil {

    public static int convertToInt(String value) {
        return convertToInt(value, 0);
    }

    public static int convertToInt(String value, int defaultValue) {
        try {
            return Integer.valueOf(value);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static float convertToFloat(String value) {
        return convertToFloat(value, 0.0f);
    }

    public static float convertToFloat(String value, float defaultValue) {
        try {
            return Float.valueOf(value);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static double convertToDouble(String value) {
        return convertToDouble(value, 0.0);
    }

    public static double convertToDouble(String value, double defaultValue) {
        try {
            return Double.valueOf(value);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }


    public static boolean convertToBoolean(String value) {
        return convertToBoolean(value, false);
    }

    public static boolean convertToBoolean(String value, boolean defaultValue) {
        try {
            return Boolean.valueOf(value);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static String format(double value) {
        return format(value, 2);
    }

    public static String format(double value, int digits) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(digits);
        numberFormat.setGroupingUsed(false);
        return numberFormat.format(value);
    }
}

