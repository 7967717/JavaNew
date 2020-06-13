import java.util.*;

public class Main {
    static Random r = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();

        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] numbers = "0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();

        sb.append(String.valueOf(generate(a, letters)).toUpperCase())
                .append(generate(b, letters))
                .append(generate(c, numbers));

        if (sb.length() < n) {
            sb.append(generate(n - sb.length(), letters));
        }

        System.out.println(sb.toString());
    }

    private static char[] generate(int count, char[] source) {
        char[] chars = new char[count];
        for (int i = 0; i < count; i++) {
            char ch = source[r.nextInt(source.length)];
            chars[i] = ch;
            while (i > 0 && ch == chars[i - 1]) {
                ch = source[r.nextInt(source.length)];
                chars[i] = ch;
            }
        }
        return chars;
    }
}