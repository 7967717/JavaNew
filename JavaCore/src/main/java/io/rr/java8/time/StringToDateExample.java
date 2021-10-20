package io.rr.java8.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringToDateExample {

    public static void main(String[] args) throws ParseException {
        String sDate1 = "2021-07-16T16:09:19+02:00";
        sDate1 = sDate1.replace('T', ' ');
        sDate1 = sDate1.substring(0, sDate1.indexOf('+'));
        System.out.println(sDate1);
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter1.parse(sDate1));
    }
}
