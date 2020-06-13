import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int lengthOfMonth = LocalDate.of(a, b, 1).lengthOfMonth();
        System.out.println(LocalDate.of(a, b, lengthOfMonth + 1 - c));
    }
}