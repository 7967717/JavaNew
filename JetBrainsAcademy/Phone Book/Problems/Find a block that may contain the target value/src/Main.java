import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int[] array = new int[s];
        for (int i = 0; i < s; i++) {
            array[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        int jumpLength = (int) Math.sqrt(array.length);
        int currentLeft = 0;
        int currentRight = jumpLength - 1;

        while (currentRight < array.length) {
            if (array[currentRight] >= target) {
                System.out.println(currentLeft + " " + currentRight);
                break;
            } else if (currentRight == array.length - 1 && target > array[currentRight]) {
                System.out.println(-1);
                break;
            }

            currentLeft = Math.min(array.length - 1, currentRight + 1);
            currentRight = Math.min(array.length - 1, currentRight + jumpLength);
        }
    }
}