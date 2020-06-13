import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String s = "move ";
        switch (i) {
            case 0:
                System.out.println("do not move");
                break;
            case 1:
                System.out.println(s + "up");
                break;
            case 2:
                System.out.println(s + "down");
                break;
            case 3:
                System.out.println(s + "left");
                break;
            case 4:
                System.out.println(s + "right");
                break;
            default:
                System.out.println("error!");
        }
    }
}