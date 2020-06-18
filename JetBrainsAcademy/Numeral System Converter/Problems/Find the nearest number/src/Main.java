import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = scanner.nextInt();
        list.sort(Comparator.naturalOrder());
        int d = Math.abs(list.get(list.size() - 1));
        for (Integer i : list) {
            int abs = Math.abs(n - i);
            if (abs < d) {
                d = abs;
            }
        }
        for (Integer i : list) {
            if (Math.abs(n - i) == d) {
                System.out.print(i + " ");
            }
        }
    }
}