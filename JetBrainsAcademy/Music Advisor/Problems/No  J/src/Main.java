import java.util.*;

public class Main {

    public static void processIterator(String[] array) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            iterator.remove();
            if (next.charAt(0) == 'J') {
                String s = next.substring(1);
                iterator.add(s);
            }
        }
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}