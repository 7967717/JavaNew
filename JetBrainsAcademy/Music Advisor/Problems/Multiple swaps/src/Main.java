import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Collections.swap(list, scanner.nextInt(), scanner.nextInt());
        }
        list.forEach(e -> System.out.print(e + " "));
    }
}