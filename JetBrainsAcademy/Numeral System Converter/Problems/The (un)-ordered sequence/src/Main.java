import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int in = scanner.nextInt();
        int inc = in;
        int dec = in;
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            if (i == 0) {
                System.out.println(flag);
                break;
            }
            if (i == inc || i > inc) {
                inc = i;
            } else if (i == dec || i < dec) {
                dec = i;
            } else {
                System.out.println(false);
                break;
            }
        }
    }
}