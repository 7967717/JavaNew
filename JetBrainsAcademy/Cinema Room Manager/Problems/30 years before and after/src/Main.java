import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        LocalDate date = LocalDate.parse(next);
        System.out.println(date.minusYears(30L));
        System.out.println(date.plusYears(30L));
    }
}