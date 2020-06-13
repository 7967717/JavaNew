import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(
                (a * b >= c && ((c % a == 0) || (c % b == 0))) ? "YES" : "NO"
        );
//        HashSet<Object> set = new HashSet<>();
//        for (int i = 1; i <= a ; i++) {
//            set.add(i * b);
//        }
//        for (int i = 1; i <= b ; i++) {
//            set.add(i * a);
//        }
//        System.out.println(set.contains(c) ? "YES" : "NO");
    }
}