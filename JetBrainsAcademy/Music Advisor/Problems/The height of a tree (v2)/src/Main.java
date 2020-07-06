import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int s = scanner.nextInt();
        int[] ints = new int[s];
        for (int i = 0; i < s; i++) {
            ints[i] = scanner.nextInt();
        }
        int root = 0;
        for (int i = 0; i < s; i++) {
            if (ints[i] == -1) {
                root = i;
                break;
            }
        }
        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(root);
        while (!list.isEmpty()) {
            count++;
            ArrayList<Integer> newList = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                if (list.contains(ints[i])) {
                    newList.add(i);
                }
            }
            list = newList;
        }
        System.out.println(count);
    }
}