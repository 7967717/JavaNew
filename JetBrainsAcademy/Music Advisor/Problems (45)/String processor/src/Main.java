import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        // implement this method
        boolean hasNext = scanner.hasNext();
        while (hasNext) {
            String next = scanner.next();
            char[] chars = next.toCharArray();
            boolean hasLowerCase = false;
            for (Character c : chars) {
                if (Character.isLowerCase(c)) {
                    hasLowerCase = true;
                    break;
                }
            }
            if (hasLowerCase) {
                System.out.println(next.toUpperCase());
                hasNext = scanner.hasNext();
            } else {
                System.out.println("FINISHED");
                break;
            }
        }
    }
}