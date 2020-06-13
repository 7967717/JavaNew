import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int[] ints = new int[s];
        for (int i = 0; i < s; i++) {
            ints[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean res = false;

        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] == n && ints[i + 1] == m) {
                res = true;
                break;
            }
            if (ints[i] == m && ints[i + 1] == n) {
                res = true;
                break;
            }
        }
        System.out.println(res);
    }
}