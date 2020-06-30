import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s1 = scanner.nextInt();
        int[] array = new int[s1];
        for (int i = 0; i < s1; i++) {
            array[i] = scanner.nextInt();
        }
        int s2 = scanner.nextInt();
        int[] col = new int[s2];
        for (int i = 0; i < s2; i++) {
            col[i] = scanner.nextInt();
        }

        for (int i : col) {
            int res = binarySearch(array, i, 0, array.length - 1);
            System.out.print((res == -1 ? res : res + 1) + " ");
        }
    }

    public static int binarySearch(int[] array, int elem, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (elem == array[mid]) {
                return mid;
            } else if (elem < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}