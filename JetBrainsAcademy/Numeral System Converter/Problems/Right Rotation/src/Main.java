import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int r = scanner.nextInt();
        String[] out = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            out[(i + r) % s.length] = s[i];
        }
        for (String s1 : out) {
            System.out.print(s1 + ' ');
        }
    }
}