import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int[] ints = new int[s];
        for (int i = 0; i < s; i++) {
            ints[i] = scanner.nextInt();
        }

        for (int i = 0; i < ints.length; i++) {
            int index = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (i % 2 == 0) {
                    if (ints[j] > ints[index]) {
                        index = j;
                    }
                } else {
                    if (ints[j] < ints[index]) {
                        index = j;
                    }
                }
            }
            int temp = ints[i];
            ints[i] = ints[index];
            ints[index] = temp;
            System.out.print(ints[i] + " ");
        }
    }
}