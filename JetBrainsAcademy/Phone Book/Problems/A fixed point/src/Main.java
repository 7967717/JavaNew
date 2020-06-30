import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int[] array = new int[s];
        for (int i = 0; i < s; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(binarySearch(array, 0, s - 1));
    }

    public static boolean binarySearch(int[] array, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = left + (right - left) / 2;

        if (mid == array[mid]) {
            return true;
        } else {
            return binarySearch(array, left, mid - 1) ||
                    binarySearch(array, mid + 1, right);
        }
    }
}