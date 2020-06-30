import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] cs = scanner.next().toLowerCase().toCharArray();
        int counter = 0;
        for (char c : cs) {
            if (c == 'g' || c == 'c') {
                counter++;
            }
        }
        System.out.println((double) counter / cs.length * 100);
    }
}