package io.rr.java8.ionio;

import lombok.SneakyThrows;

import java.io.File;
import java.util.Scanner;

public class CountLines {
    @SneakyThrows
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new File("src/main/resources/data/dataset_91033.txt"));
        int counter = 0;
        while (scanner.hasNextInt()) {
            counter += scanner.nextInt();
        }
        System.out.println(counter);
    }
}
