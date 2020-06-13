import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String n = scanner.nextLine();
        System.out.println(
                Math.abs(LocalTime.parse(n).toSecondOfDay() - LocalTime.parse(s).toSecondOfDay())
        );
    }
}