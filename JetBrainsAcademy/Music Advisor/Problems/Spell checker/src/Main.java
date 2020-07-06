import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        HashSet<String> dict = new HashSet<>();
        for (int i = 0; i < d; i++) {
            dict.add(scanner.next().toLowerCase());
        }

        HashSet<String> errs = new HashSet<>();
        scanner.nextInt();
        while (scanner.hasNextLine()){
            Set<String> set = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                    .filter(e -> !dict.contains(e.toLowerCase())).collect(Collectors.toSet());
            errs.addAll(set);
        }
        errs.forEach(System.out::println);
    }
}
