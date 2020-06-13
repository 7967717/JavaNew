import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String ss = scanner.next();
        int count = 0;
        while (s.contains(ss)) {
            count++;
            s = s.substring(s.indexOf(ss) + ss.length());
            System.out.println(s);
        }
        System.out.println(count);

    }
}