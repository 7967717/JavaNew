package io.rr.java8.ionio;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/dataset_91022.txt"));
        int count = 0;
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            if (i >= 9999) {
                count++;
            }
        }
        System.out.println(count);
    }
}
