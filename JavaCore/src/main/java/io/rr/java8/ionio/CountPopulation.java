package io.rr.java8.ionio;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountPopulation {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/data/dataset_91069.txt"));
        scanner.nextLine();
        int year = scanner.nextInt();
        long prevPop = scanner.nextLong();
        long increase = 0;
        int res = year;
        while (scanner.hasNext()) {
            year = scanner.nextInt();
            long currPop = scanner.nextLong();
            if (currPop - prevPop > increase) {
                res = year;
                increase = currPop - prevPop;
            }
            prevPop = currPop;
        }
        System.out.println(res);
    }
}
