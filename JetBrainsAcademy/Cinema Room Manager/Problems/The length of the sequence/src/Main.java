import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (scanner.hasNext()) {
            if(scanner.nextInt() == 0){
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}