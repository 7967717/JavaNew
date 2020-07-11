import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }
        int res = 0;
        for (int i = 0; i < ints.length - 1; i++) {
            int j = ints[i] * ints[i + 1];
            if (j > res) {
                res = j;
            }
        }
        System.out.println(res);
    }
}