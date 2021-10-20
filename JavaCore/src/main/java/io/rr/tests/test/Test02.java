package io.rr.tests.test;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String string = new StringBuffer(next).reverse().toString();
        int i = Integer.parseInt(string);
        System.out.println(i);
    }
}
