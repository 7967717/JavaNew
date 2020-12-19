import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        LocalDate date = LocalDate.parse(s);
        System.out.println(date.getDayOfYear() + " " + date.getDayOfMonth());
    }
}