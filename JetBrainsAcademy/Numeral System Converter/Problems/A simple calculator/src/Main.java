import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        long a = Long.parseLong(s[0]);
        String i = s[1];
        long b = Long.parseLong(s[2]);
        switch (i) {
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            case "*":
                System.out.println(a * b);
                break;
            case "/":
                System.out.println(b == 0 ? "Division by 0!" : a / b);
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}