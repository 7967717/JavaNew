import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int[] ints = new int[s];
            for (int j = 0; j < s; j++) {
                ints[j] = scanner.nextInt();
            }
            list.add(selectionSort(ints));
        }
        Integer max = list.stream().max(Comparator.naturalOrder()).orElseThrow();
        System.out.println(list.indexOf(max) + 1);
    }

    public static int selectionSort(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int index = i; // the index of the found min

            /* Iterating over the unsorted subarray to find the min */
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                    count++;
                }
            }

            /* Exchanging the found min and the current element */
            int min = array[index];
            array[index] = array[i];
            array[i] = min;
        }

        return count;
    }

}