import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int[] ints = new int[s];
        for (int i = 0; i < s; i++) {
            ints[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int counter = 0;
        for (int i : ints) {
            if (i == n) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}