import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        LocalDate date = LocalDate.parse(n);
        LocalDate date1 = date.plusWeeks(2);
        System.out.println(date1);
    }
}