package io.rr.java8.time;

import java.time.*;
import java.time.temporal.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class App01 {
    public static void main(String[] args) {
        Instant now = Instant.now();
        Instant tomorrow = Instant.now().plus(Duration.ofDays(1));
        System.out.println(Duration.between(now, tomorrow));

        days1(2020);

    }

    private static void days(int year) {
        IntStream.range(1, 12)
                .mapToObj(x -> YearMonth.of(year, x))
                .forEach(d -> System.out.println(d.getMonth() + "-" + d.lengthOfMonth()));
    }

    private static void days1(int year) {
        Arrays.stream(Month.values())
                .map(x -> YearMonth.of(year, x))
                .peek(d -> System.out.println(d.getMonth() + " has " + d.lengthOfMonth() + " days"))
                .peek(App01::mondays)
                .forEach(App01::friday13);
    }

    private static void mondays(YearMonth m) {
        System.out.println("MONDAYs are:");
        LocalDate date = m.atDay(1).with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        Month month = m.getMonth();
        while (month == m.getMonth()) {
            System.out.println(date);
            date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            month = date.getMonth();
        }
    }

    private static void friday13(YearMonth m) {
        LocalDate date = m.atDay(1);
        Month month = m.getMonth();
        while (month == m.getMonth()) {
//            if (date.get(ChronoField.DAY_OF_MONTH) == 13 && date.get(ChronoField.DAY_OF_WEEK) == 5) { the same as below
            if (date.getDayOfMonth() == 13 && date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                System.out.println("the month has " + date.getDayOfWeek() + " " + date.getDayOfMonth());
            }
            date = date.plusDays(1);
            month = date.getMonth();
        }
    }
}
