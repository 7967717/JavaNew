import java.util.Scanner;
import java.util.Stack;

class Main {
    private static Stack stack = new Stack();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        partition(n);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static void partition(int n) {
        partition(n, n, "");
    }

    public static void partition(int n, int max, String prefix) {
        if (n == 0) {
            stack.push(prefix);
            return;
        }

        for (int i = Math.min(max, n); i >= 1; i--) {
            partition(n - i, i, prefix + " " + i);
        }
    }
}