package io.rr.tests.luxoft;

//In a 2D matrix, every row ins increasingly sorted from left to right.
// Last number in each row is not greater then first number in next row.
// Write java function to check if there is a number in the matrix

//6

//123
//567
//8910

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {

//    public static void main(String[] args) {

//        List<String> list = Arrays.asList(Locale.getISOCountries());
//
//        list.size();
////        System.out.println(list);
//
//        list.stream()
////                .map(code -> new Locale("", code))
//                .collect(Collectors.toMap(Function.identity(), code -> new Locale("", code), (s0, s1) -> s0, TreeMap::new))
//                .forEach((k, v) -> System.out.println(k + " -> " + v.getDisplayCountry()));
//
//        Locale ad = new Locale("", "ad");
//        System.out.println(ad.getDisplayCountry());
//
//        Locale.IsoCountryCode

//        var internal0 = List.of(1,2,3);
//        var internal1 = List.of(5,6,7);
//        var internal2 = List.of(8,9,10);
//        var lists = List.of(internal0, internal1, internal2);
//
//        Integer given = 6;
//
//        Optional<Boolean> first = lists.stream().map(l -> l.contains(given)).findFirst();



//    }

    public static void main(String[] args) {
        List<Optional<?>> optionals = List.of(Optional.of(Integer.valueOf(1)), Optional.empty(), Optional.of(Integer.valueOf(3)), Optional.empty(), Optional.of(Integer.valueOf(5)));
        System.out.println(optionals);
        List<?> list = optionals.stream().flatMap(Optional::stream).toList();
        System.out.println(list);


    }



}
