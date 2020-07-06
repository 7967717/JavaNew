import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split("\\s+");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i += 2) {
            list.add(arr[i]);
        }
        Collections.reverse(list);
        list.forEach(e -> System.out.print(e + " "));
    }
}