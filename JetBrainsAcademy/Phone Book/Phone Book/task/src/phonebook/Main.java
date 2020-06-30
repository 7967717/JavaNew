package phonebook;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

import static java.time.temporal.ChronoField.MILLI_OF_SECOND;

public class Main {

    public static final String DIRECTORY = "/Users/roman/IdeaProjects/JavaNew/JetBrainsAcademy/directory.txt";
    public static final String FIND = "/Users/roman/IdeaProjects/JavaNew/JetBrainsAcademy/find.txt";
    private static long linearSearchTime;
    private static long sortingStart;
    private static boolean stopSorting = false;

    public static void main(String[] args) {
        linearSearch();
        jumpSearch();
        binarySearch();
        hashTable();
    }

    private static void hashTable() {
        try (Scanner scannerD = new Scanner(new File(DIRECTORY));
             Scanner scannerF = new Scanner(new File(FIND))) {
            System.out.println("Start searching (hash table)...");
            long start = System.currentTimeMillis();

            long creatingStart = System.currentTimeMillis();
            List<String[]> dir = readDir(scannerD);
            List<String> find = readFind(scannerF);
//            HashTable<String, String> table = new HashTable<>(dir.size());
//            HashTable<String, String> table = new HashTable<>(dir.size() * 2);
            HashTable<String, String> table = new HashTable<>(dir.size() * 3);
            dir.forEach(e -> table.put(e[0], e[1]));
            long creatingFinish = System.currentTimeMillis();

            long searchStart = System.currentTimeMillis();
            long count = find.stream().map(table::get).filter(Objects::nonNull).count();
            long searchFinish = System.currentTimeMillis();

            long finish = System.currentTimeMillis();
            LocalTime time = getLocalTime(finish - start);
            LocalTime sortingTime = getLocalTime(creatingFinish - creatingStart);
            LocalTime searchingTime = getLocalTime(searchFinish - searchStart);

            System.out.print("Found " + count + "/" + find.size() + " entries. ");
            System.out.println("Time taken: " + time.getMinute() + " min. " +
                    time.getSecond() + " sec. " + time.get(MILLI_OF_SECOND) + " ms.");
            System.out.println("Creating time: " + sortingTime.getMinute() + " min. " +
                    sortingTime.getSecond() + " sec. " + sortingTime.get(MILLI_OF_SECOND) + " ms. ");
            System.out.println("Searching time: " + searchingTime.getMinute() + " min. " +
                    searchingTime.getSecond() + " sec. " + searchingTime.get(MILLI_OF_SECOND) + " ms.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void binarySearch() {
        try (Scanner scannerD = new Scanner(new File(DIRECTORY));
             Scanner scannerF = new Scanner(new File(FIND))) {
            System.out.println("Start searching (quick sort + binary search)...");
            long start = System.currentTimeMillis();

            long sortingStart = System.currentTimeMillis();
            String[][] dir = readDir(scannerD).toArray(new String[0][]);
            List<String> find = readFind(scannerF);
            quickSort(dir, 0, dir.length - 1);
            long sortingFinish = System.currentTimeMillis();

            long searchStart = System.currentTimeMillis();
            int count = find.stream()
                    .mapToInt(e -> (binarySearch(dir, e, 0, dir.length - 1) >= 0) ? 1 : 0).sum();
            long searchFinish = System.currentTimeMillis();

            long finish = System.currentTimeMillis();
            LocalTime time = getLocalTime(finish - start);
            LocalTime sortingTime = getLocalTime(sortingFinish - sortingStart);
            LocalTime searchingTime = getLocalTime(searchFinish - searchStart);

            System.out.print("Found " + count + "/" + find.size() + " entries. ");
            System.out.println("Time taken: " + time.getMinute() + " min. " +
                    time.getSecond() + " sec. " + time.get(MILLI_OF_SECOND) + " ms.");
            System.out.println("Sorting time: " + sortingTime.getMinute() + " min. " +
                    sortingTime.getSecond() + " sec. " + sortingTime.get(MILLI_OF_SECOND) + " ms. ");
            System.out.println("Searching time: " + searchingTime.getMinute() + " min. " +
                    searchingTime.getSecond() + " sec. " + searchingTime.get(MILLI_OF_SECOND) + " ms.");
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int binarySearch(String[][] array, String elem, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2; // the index of the middle element

            if (elem.equals(array[mid][0])) {
                return mid; // the element is found, return its index
            } else if (elem.compareTo(array[mid][0]) < 0) {
                right = mid - 1; // go to the left subarray
            } else {
                left = mid + 1;  // go the the right subarray
            }
        }
        return -1; // the element is not found
    }

    private static void quickSort(String[][] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right); // the pivot is already on its place
            quickSort(array, left, pivotIndex - 1);  // sort the left subarray
            quickSort(array, pivotIndex + 1, right); // sort the right subarray
        }
    }

    private static int partition(String[][] array, int left, int right) {
        String pivot = array[right][0];  // choose the rightmost element as the pivot
        int partitionIndex = left; // the first element greater than the pivot

        /* move large values into the right side of the array */
        for (int i = left; i < right; i++) {
            if (array[i][0].compareTo(pivot) <= 0) { // may be used '<' as well
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }

        swap(array, partitionIndex, right); // put the pivot on a suitable position

        return partitionIndex;
    }

    private static void swap(String[][] array, int i, int j) {
        String[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void jumpSearch() {
        try (Scanner scannerD = new Scanner(new File(DIRECTORY));
             Scanner scannerF = new Scanner(new File(FIND))) {

            System.out.println("Start searching(bubble sort + jump search)...");
            long start = System.currentTimeMillis();
            sortingStart = System.currentTimeMillis();
            List<String[]> dir = readDir(scannerD);
            List<String> find = readFind(scannerF);

            bubbleSort(dir);
            long sortingFinish = System.currentTimeMillis();

            long searchStart = System.currentTimeMillis();
            long count;
            if (stopSorting) {
                count = dir.stream().filter(e -> find.contains(e[0])).count();
            } else {
                count = find.stream().filter(e -> jumpSearch(dir, e).isPresent()).count();
            }
            long searchFinish = System.currentTimeMillis();

            long finish = System.currentTimeMillis();
            LocalTime time = getLocalTime(finish - start);
            LocalTime sortingTime = getLocalTime(sortingFinish - sortingStart);
            LocalTime searchingTime = getLocalTime(searchFinish - searchStart);

            System.out.print("Found " + count + "/" + find.size() + " entries. ");
            System.out.println("Time taken: " + time.getMinute() + " min. " +
                    time.getSecond() + " sec. " + time.get(MILLI_OF_SECOND) + " ms.");
            System.out.println("Sorting time: " + sortingTime.getMinute() + " min. " +
                    sortingTime.getSecond() + " sec. " + sortingTime.get(MILLI_OF_SECOND) + " ms. "
                    + (stopSorting ? "- STOPPED, moved to linear search" : ""));
            System.out.println("Searching time: " + searchingTime.getMinute() + " min. " +
                    searchingTime.getSecond() + " sec. " + searchingTime.get(MILLI_OF_SECOND) + " ms.");
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void bubbleSort(List<String[]> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (System.currentTimeMillis() - sortingStart > linearSearchTime * 2) {
                    stopSorting = true;
                    return;
                }

                if (list.get(j)[0].compareTo(list.get(j + 1)[0]) > 0) {
                    String[] temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    private static Optional<String[]> jumpSearch(List<String[]> list, String target) {
        int currentRight = 0; // right border of the current block
        int prevRight = 0; // right border of the previous block

        /* If list is empty, the element is not found */
        if (list.size() == 0) {
            return Optional.empty();
        }

        /* Check the first element */
        if (list.get(currentRight)[0].equals(target)) {
            return Optional.of(list.get(0));
        }

        /* Calculating the jump length over list elements */
        int jumpLength = (int) Math.sqrt(list.size());

        /* Finding a block where the element may be present */
        while (currentRight < list.size() - 1) {

            /* Calculating the right border of the following block */
            currentRight = Math.min(list.size() - 1, currentRight + jumpLength);

            if (list.get(currentRight)[0].compareTo(target) >= 0) {
                break; // Found a block that may contain the target element
            }

            prevRight = currentRight; // update the previous right block border
        }

        /* If the last block is reached and it cannot contain the target value => not found */
        if ((currentRight == list.size() - 1) && target.compareTo(list.get(currentRight)[0]) > 0) {
            return Optional.empty();
        }

        /* Doing linear search in the found block */
        return backwardSearch(list, target, prevRight, currentRight);
    }

    private static Optional<String[]> backwardSearch(List<String[]> list, String target, int leftExcl, int rightIncl) {
        for (int i = rightIncl; i > leftExcl; i--) {
            if (list.get(i)[0].equals(target)) {
                return Optional.of(list.get(i));
            }
        }
        return Optional.empty();
    }

    private static void linearSearch() {
        try (Scanner scannerD = new Scanner(new File(DIRECTORY));
             Scanner scannerF = new Scanner(new File(FIND))) {

            System.out.println("Start searching(linear search)...");
            long start = System.currentTimeMillis();
            List<String[]> dir = readDir(scannerD);
            List<String> find = readFind(scannerF);

            long count = dir.stream().filter(e -> find.contains(e[0])).count();
//            long count = find.stream().filter(f -> dir.stream().anyMatch(d -> d[0].equals(f))).count();
            long finish = System.currentTimeMillis();
            linearSearchTime = finish - start;
            LocalTime time = getLocalTime(linearSearchTime);

            System.out.print("Found " + count + "/" + find.size() + " entries. ");
            System.out.println("Time taken: " + time.getMinute() + " min. " +
                    time.getSecond() + " sec. " + time.get(MILLI_OF_SECOND) + " ms.");
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static LocalTime getLocalTime(long ms) {
        return Instant.ofEpochMilli(ms).atZone(ZoneId.systemDefault()).toLocalTime();
    }

    @NotNull
    private static List<String[]> readDir(Scanner scannerD) {
        List<String[]> dir = new ArrayList<>();
        while (scannerD.hasNext()) {
            String[] elem = new String[2];
            elem[1] = scannerD.next();
            elem[0] = scannerD.nextLine().trim();
            dir.add(elem);
        }
        return dir;
    }

    @NotNull
    private static List<String> readFind(Scanner scannerF) {
        List<String> find = new ArrayList<>();
        while (scannerF.hasNext()) {
            find.add(scannerF.nextLine().trim());
        }
        return find;
    }

    private static class TableEntry<K, V> {
        private final K key;
        private final V value;

        public TableEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private static class HashTable<K, V> {
        private final int size;
        private final TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(K key, V value) {
            int index = findKey(key);

            if (index == -1) {
                return false;
            }
            table[index] = new TableEntry(key, value);
            return true;
        }

        public V get(K key) {
            int index = findKey(key);

            if (index == -1 || table[index] == null) {
                return null;
            }
            return (V) table[index].value;
        }

        public void remove(K key) {
            int index = findKey(key);
            table[index] = null;
        }

        private int findKey(K key) {
            int hc = Math.abs(key.hashCode());
            int hash = hc % size;

            while (!(table[hash] == null || table[hash].getKey().equals(key))) {
                hash = (hash + 1) % size;

                if (hash == hc % size) {
                    return -1;
                }
            }

            return hash;
        }
    }

}


