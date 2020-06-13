import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        System.out.println(s.substring(i, j + 1));
    }
}