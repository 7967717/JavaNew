package io.rr.algorithms.princeton;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(s(new int[]{1, 3, 5, 6, 7, 8}, 5));
        System.out.println(s(new int[]{1, 3, 5, 7, 8}, 6));

    }

    private static int s(int[] a, int e) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (e < a[mid]) high = mid - 1;
            else if (e > a[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }
}