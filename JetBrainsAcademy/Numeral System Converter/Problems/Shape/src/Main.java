import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String s = "You have chosen a ";
        switch (i) {
            case 1:
                System.out.println(s + "square");
                break;
            case 2:
                System.out.println(s + "circle");
                break;
            case 3:
                System.out.println(s + "triangle");
                break;
            case 4:
                System.out.println(s + "rhombus");
                break;
            default:
                System.out.println("There is no such shape!");
        }
    }
}