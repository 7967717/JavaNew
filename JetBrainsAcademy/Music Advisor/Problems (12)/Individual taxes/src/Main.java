import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] incomes = new int[n];
        int[] taxes = new int[n];
        for (int i = 0; i < n; i++) {
            incomes[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            taxes[i] = scanner.nextInt();
        }
        int most = 1;
        double maxAmount = 0;
        for (int i = 0; i < n; i++) {
            double payment = (double) incomes[i] / 100 * taxes[i];
            if (payment > maxAmount) {
                maxAmount = payment;
                most = i + 1;
            }
        }
        System.out.println(most);
    }
}