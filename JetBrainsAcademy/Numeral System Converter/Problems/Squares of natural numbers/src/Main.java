import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int j = 1;
        int s = 1;
        int i = scanner.nextInt();
        while (s <= i) {
            System.out.println(s);
            j++;
            s = j * j;
        }
    }
}