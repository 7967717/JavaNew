import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            System.out.print(--i + " ");
        }
    }
}