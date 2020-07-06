import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int s = scanner.nextInt();
        int[] prns = new int[s];
        int[] chs = new int[s];
        for (int i = 0; i < s; i++) {
            prns[i] = scanner.nextInt();
            chs[i] = scanner.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int ch : chs) {
            boolean contains = false;
            for (int prn : prns) {
                if (ch == prn) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                list.add(ch);
            }
        }
        System.out.println(list.size());
        list.forEach(e -> System.out.print(e + " "));
    }
}