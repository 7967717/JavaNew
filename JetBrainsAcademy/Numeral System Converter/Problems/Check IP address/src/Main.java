import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        String part = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String matcher = String.join("\\.", part, part, part, part);
        System.out.println(ip.matches(matcher) ? "YES" : "NO");
    }
}