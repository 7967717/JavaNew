import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int a = scanner.nextInt();
        LocalDate date = LocalDate.parse(s);
        int year = date.getYear();
        while (date.getYear() == year) {
            System.out.println(date);
            date = date.plusDays(a);
        }
    }
}