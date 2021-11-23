package io.rr.tests.test;

import java.util.ArrayList;
import java.util.HashMap;

public class Test01 {

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < 10; i++) {
      list.add(i);
      map.put(String.valueOf(i), i);
    }

    list.stream().filter(integer -> integer % 2 == 0).forEach(System.out::println);
    map.entrySet().stream()
        .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
  }
}
