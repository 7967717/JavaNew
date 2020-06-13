import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int max = 0;
        int j = 0;
        int i = scanner.nextInt();
        while (j < i) {
            j++;
            int k = scanner.nextInt();
            if (k % 4 == 0 && k > max) {
                max = k;
            }
        }
        System.out.println(max);
    }
}