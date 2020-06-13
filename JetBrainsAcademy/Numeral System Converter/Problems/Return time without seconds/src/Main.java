import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        LocalTime time = LocalTime.parse(s);
        System.out.println(time.withSecond(0));
    }
}