import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        int i = scanner.nextInt();
        String res = next;
        if (i >= next.length()) {
            System.out.println(res);
        } else {
            System.out.println(next.substring(i) + next.substring(0, i));
        }
    }
}
