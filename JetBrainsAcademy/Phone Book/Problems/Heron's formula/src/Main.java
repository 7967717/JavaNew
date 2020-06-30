import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();

        double hp = (a + b + c) / 2;
        double ar = Math.sqrt(hp * (hp - a) * (hp - b) * (hp - c));
        System.out.println(ar);
    }
}