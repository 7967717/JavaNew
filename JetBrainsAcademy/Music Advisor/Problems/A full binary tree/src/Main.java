import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int s = scanner.nextInt();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            list.add(new int[]{scanner.nextInt(), scanner.nextInt()});
        }
        String res = "yes";
        for (int[] pair : list) {
            int parent = pair[0];
            if (list.stream().filter(e -> e[0] == parent).count() != 2) {
                res = "no";
                break;
            }
        }
        System.out.println(res);
    }
}