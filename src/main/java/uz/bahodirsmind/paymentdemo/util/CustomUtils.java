package uz.bahodirsmind.paymentdemo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomUtils {
    private static SimpleDateFormat comfortableDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Date comfortStrFormToDate(String date) throws ParseException {
        if (isNotNullOrEmpty(date)) {
            return comfortableDateFormat.parse(date);
        } else {
            return null;
        }
    }

    public static boolean isNotNullOrEmpty(String string) {
        return (string != null && !string.equals("null") && !string.trim().isEmpty());
    }
}
