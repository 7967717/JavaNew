import java.util.*;

public class Main {

    public static void moveThePivot(int[] array, int pivotIndex) {
        int pivot = array[pivotIndex];
        int partitionIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < pivot) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == pivot) {
                pivotIndex = i;
            }
        }

        swap(array, partitionIndex, pivotIndex);

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int pivotIndex = scanner.nextInt();
        moveThePivot(array, pivotIndex);
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
    }
}