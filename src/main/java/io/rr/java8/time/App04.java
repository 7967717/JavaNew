package io.rr.java8.time;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class App04 {

    public static void main(String[] args) {


        LocalDateTime leaving = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
        System.out.println(leaving);
        System.out.println(leaving.atZone(ZoneId.of("America/Los_Angeles")));
        System.out.println(leaving.atZone(ZoneId.of("America/Los_Angeles")).withZoneSameInstant(ZoneId.of("Asia/Tokyo")));
        System.out.println(leaving.atZone(ZoneId.of("America/Los_Angeles"))
                .withZoneSameInstant(ZoneId.of("Asia/Tokyo")).plus(Duration.ofMinutes(650)));

        System.out.printf("now: %s%n", LocalDateTime.now());

        LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20);
        LocalDate nextWed = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        System.out.println(date.getDayOfWeek());
        System.out.println(nextWed);
        System.out.println();
        System.out.println(Instant.now());
        System.out.println(Instant.now().atZone(ZoneId.of("UTC")));
        System.out.println(Instant.now().atZone(ZoneId.of("UTC")).toInstant());
        System.out.println(Instant.now().atZone(ZoneId.of("Europe/Kiev")));
        System.out.println(OffsetDateTime.now(ZoneOffset.UTC));
        System.out.println(OffsetDateTime.now(ZoneOffset.MAX));
        System.out.println(OffsetDateTime.now(ZoneOffset.MIN));
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
        System.out.println(LocalTime.now());
        System.out.println(ZonedDateTime.now());
        System.out.println(OffsetDateTime.now());
        System.out.println(MonthDay.now());
        System.out.println(YearMonth.now());
        System.out.println(Duration.ofHours(25));
        System.out.println(Period.ofDays(2));
        System.out.println(ZoneId.systemDefault());
        System.out.println(ZoneOffset.systemDefault());

        LocalDateTime dt = LocalDateTime.now();
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        TreeSet<String> set = new TreeSet<>();

        for (String a : zoneIds) {
            ZoneId zone = ZoneId.of(a);
            ZonedDateTime zdt = dt.atZone(zone);
            ZoneOffset offset = zdt.getOffset();
            set.add(offset + " " + a);

//            System.out.println(a + " " + offset);
//            System.out.println(a + " " + zoneIds.size());
        }
//
//        for (String s: set) {
//            System.out.println(s);
//        }
    }

}
