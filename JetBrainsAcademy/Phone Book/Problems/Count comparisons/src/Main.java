import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int[] array = new int[s];
        for (int i = 0; i < s; i++) {
            array[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        int currentRight = 0;
        int prevRight = 0;

        int count = 1;

        if (array[currentRight] == target) {
            System.out.println(count);
            return;
        }

        int jumpLength = (int) Math.sqrt(array.length);

        while (currentRight < array.length - 1) {
            count++;
            currentRight = Math.min(array.length - 1, currentRight + jumpLength);

            if (array[currentRight] >= target) {
                break;
            }

            prevRight = currentRight;
        }

        if (currentRight == array.length - 1 && target > array[currentRight]) {
            System.out.println(count);
            return;
        }

        count = backwardSearch(array, target, currentRight, prevRight, count);

        System.out.println(count);
    }

    private static int backwardSearch(int[] array, int target, int currentRight, int prevRight, int count) {
        int inc = count;
        for (int i = currentRight; i > prevRight; i--) {
            if (array[i] == target) {
                break;
            } else if (array[i] < target) {
                break;
            } else if (i == prevRight + 1 && array[i] != target) {
                break;
            } else {
                inc++;
            }
        }
        return inc;
    }
}