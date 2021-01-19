import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Map<String, Integer> map0 = Map.of("Omega", 24, "Alpha", 1, "Gamma", 3);
        TreeMap<String, Integer> map = new TreeMap<>(map0);
        System.out.println(map);
    }
}