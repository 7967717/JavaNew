package io.rr.java8.ionio;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountLines {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/data/dataset_91033.txt"));
        int counter = 0;
        while (scanner.hasNextInt()) {
            counter += scanner.nextInt();
        }
        System.out.println(counter);
    }
}
