import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int i = scanner.nextInt();
        int i1 = scanner.nextInt();
        int i2 = scanner.nextInt();
        System.out.println((i > 0 && i1 <= 0 && i2 <= 0) ||
                (i <= 0 && i1 > 0 && i2 <= 0) ||
                (i <= 0 && i1 <= 0 && i2 > 0));
    }
}