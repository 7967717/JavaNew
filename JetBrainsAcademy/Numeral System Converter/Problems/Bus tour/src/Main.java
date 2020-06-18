import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int n = scanner.nextInt();
        String message = "Will not crash";
        for (int i = 1; i <= n; i++) {
            if (h >= scanner.nextInt()) {
                message = "Will crash on bridge " + i;
                break;
            }
        }
        System.out.println(message);
    }
}