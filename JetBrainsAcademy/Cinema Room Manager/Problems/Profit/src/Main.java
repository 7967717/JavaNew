import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        double m = Integer.parseInt(strings[0]);
        int p = Integer.parseInt(strings[1]);
        int k = Integer.parseInt(strings[2]);
        int y = 0;
        while (m < k) {
            m = m + (m / 100 * p);
            y++;
        }
        System.out.println(y);
    }
}