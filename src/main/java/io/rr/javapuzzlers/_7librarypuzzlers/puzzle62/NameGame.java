package io.rr.javapuzzlers._7librarypuzzlers.puzzle62;

import java.util.*;

public class NameGame {
    public static void main(String args[]) {
        Map<String, String> m = new /*IdentityHashMap*/ HashMap<>();
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
        System.out.println(m.size());
    } 
}
