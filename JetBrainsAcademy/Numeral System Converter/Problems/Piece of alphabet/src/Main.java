import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] chars = s.toCharArray();
        boolean res = true;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i] - 1) {
                res = false;
                break;
            }
        }
        System.out.println(res);
    }
}