import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        if (s >= 0 && s < 2) {
            System.out.println(s);
        } else {
            int[] res = new int[s];
            int jumpLength = (int) Math.sqrt(s);
            int prevRight = 0;
            int currentRight = 0;
            int count = 1;
            res[0] = count;
            while (currentRight < s - 1) {
                currentRight = Math.min(s - 1, currentRight + jumpLength);

                backwardFill(res, count, prevRight, currentRight);

                prevRight = currentRight;
                count++;
            }
            Arrays.stream(res).forEach(value -> System.out.print(value + " "));
        }
    }

    public static void backwardFill(int[] array, int count, int leftExcl, int rightIncl) {
        int intCount = count;
        for (int i = rightIncl; i > leftExcl; i--) {
            array[i] = ++intCount;
        }
    }
}