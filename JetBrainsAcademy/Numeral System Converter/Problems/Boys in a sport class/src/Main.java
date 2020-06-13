import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int i = scanner.nextInt();
        int i1 = scanner.nextInt();
        int i2 = scanner.nextInt();
        System.out.println((i >= i1 && i1 >= i2) ||
                (i <= i1 && i1 <= i2));
    }
}