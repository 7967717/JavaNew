import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int c = 0;
        int r = 0;
        while (true) {
            r++;
            c += a;
            if (c >= h) {
                break;
            }
            c -= b;
        }
        System.out.println(r);
    }
}