import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = a; i <= b ; i++) {
            if(i % 3 == 0) {
                list.add(i);
            }
        }
        System.out.println(list.stream().mapToDouble(x -> x).average().getAsDouble());
    }
}