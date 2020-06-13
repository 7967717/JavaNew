//put imports you need here

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            String[] strings = scanner.nextLine().split(" ");
            list.addAll(Arrays.asList(strings));
        }
        Collections.reverse(list);
        list.forEach(System.out::println);
    }
}