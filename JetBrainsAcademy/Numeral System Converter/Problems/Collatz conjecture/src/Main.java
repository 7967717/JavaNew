import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int j = 0;
        int i = scanner.nextInt();
        System.out.print(i + " ");
        while (i != 1) {
            if(i % 2 == 0) {
                i = i / 2;
            } else {
                i = i * 3 + 1;
            }
            System.out.print(i + " ");
        }
    }
}