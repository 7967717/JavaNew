import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double sqrt = Math.sqrt(b * b - 4 * a * c);
        double r1 = ((-b) + sqrt) / (2 * a);
        double r2 = ((-b) - sqrt) / (2 * a);
        System.out.println(Math.min(r1, r2) + " " + Math.max(r1, r2));
    }
}
