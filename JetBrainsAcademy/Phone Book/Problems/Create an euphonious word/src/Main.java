import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next().toLowerCase();
        int res = 0;
        String pattern1 = "[aeiouy]{3}";
        String pattern2 = "[^aeiouy]{3}";

        for (int i = 0; i < s.length() - 2; i++) {
            String substring = s.substring(i, i + 3);
            if (substring.matches(pattern1) || substring.matches(pattern2)) {
                res++;
                i++;
            }
        }

        System.out.println(res);
    }
}