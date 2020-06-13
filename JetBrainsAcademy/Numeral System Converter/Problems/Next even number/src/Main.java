import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int i = scanner.nextInt();
        System.out.println((i % 2 == 0) ? i + 2 : i + 1);
    }
}