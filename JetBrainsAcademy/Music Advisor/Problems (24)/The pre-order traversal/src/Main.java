import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        go(0, 0, s);
    }

    private static void go(int node, int level, int depth) {
        if (level <= depth) {
            System.out.print(node + " ");
            go((node * 3 + 1), level + 1, depth);
            go((node * 3 + 2), level + 1, depth);
            go((node * 3 + 3), level + 1, depth);
        }
    }
}