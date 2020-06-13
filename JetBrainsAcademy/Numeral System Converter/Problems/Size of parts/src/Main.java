import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int a = 0;
        int b = 0;
        int c = 0;
        int i = scanner.nextInt();
        for (int j = 1; j <= i; j++) {
            int k = scanner.nextInt();
            if (k == 0) {
                a++;
            } else if (k == 1) {
                b++;
            } else {
                c++;
            }

        }
        System.out.println(a + " " + b + " " + c);
    }
}