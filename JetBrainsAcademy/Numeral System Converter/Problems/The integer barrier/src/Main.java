import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (true) {
            int i = scanner.nextInt();
            if (sum >= 1000) {
                System.out.println(sum - 1000);
                break;
            }
            else if (i == 0) {
                System.out.println(sum);
                break;
            } else {
                sum = sum + i;
            }
        }
    }
}