import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int s = scanner.nextInt();
        Character[] chars = new Character[s];
        for (int i = 0; i < s; i++) {
            chars[i] = scanner.next().charAt(0);
        }
        Arrays.stream(countingSort(chars)).forEach(e -> System.out.print(e + " "));
    }

    public static Character[] countingSort(Character[] numbers) {
        List<Character> list = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j');
        int l = list.size();
        int[] counts = new int[l]; // it stores 11 zeros with indexes from 0 to k-1

        /* in this loop we count distinct numbers in the input array */
        for (int i = 0; i < numbers.length; i++) {
            counts[list.indexOf(numbers[i])]++;
        }

        int pos = 0; // a position in the numbers array

        /* in this loop we modify the input array to make it sorted */
        for (int num = 0; num < l; num++) { // get the next element
            int count = counts[num]; // get the count of the element
            while (count > 0) {
                numbers[pos] = list.get(num); // write it in the numbers array
                pos++;
                count--;
            }
        }

        return numbers;
    }
}