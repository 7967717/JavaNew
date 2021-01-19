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

        int sum = 0;
        for (int i : ints) {
            if (i > n) {
                sum = sum + i;
            }
        }

        System.out.println(sum);
    }
}