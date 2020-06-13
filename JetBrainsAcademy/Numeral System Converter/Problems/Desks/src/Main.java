import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int r = 0;
        for (int i = 0; i < 3; i++) {
            int ii = scanner.nextInt();
            r = r + (ii / 2 + ii % 2);
        }
        System.out.println(r);
    }
}