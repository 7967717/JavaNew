package io.rr.javapuzzlers._7librarypuzzlers.puzzle61;

import java.util.*;

public class DatingGame {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(1999, /*12*/ Calendar.DECEMBER, 31); // Year, Month, Day
        System.out.print(cal.get(Calendar.YEAR) + " ");

//        Date d = cal.getTime();
//        System.out.println(d.getDay());
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
    }
}
