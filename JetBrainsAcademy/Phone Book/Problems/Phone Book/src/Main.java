import java.util.Scanner;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;
        private boolean removed;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public void remove() {
            removed = true;
        }

        public boolean isRemoved() {
            return removed;
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int index = findKey(key);

            if (index == -1) {
                return false;
            }
            table[index] = new TableEntry(key, value);
            return true;
        }

        public T get(int key) {
            int index = findKey(key);

            if (index == -1 || table[index] == null) {
                return null;
            }
            return (T) table[index].value;
        }

        public void remove(int key) {
            int index = findKey(key);
            table[index] = null;
        }

        private int findKey(int key) {
            int hash = key % size;

            while (!(table[hash] == null || table[hash].key == key)) {
                hash = (key + 1) % size;
                if (hash == key % size) {
                    return -1;
                }
            }
            return hash;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashTable<String> table = new HashTable<>(n);
        for (int i = 0; i < n; i++) {
            String op = scanner.next();
            if (op.equalsIgnoreCase("put")) {
                table.put(scanner.nextInt(), scanner.next());
            } else if (op.equalsIgnoreCase("get")) {
                String s = table.get(scanner.nextInt());
                System.out.println(s == null ? -1 : s);
            } else {
                table.remove(scanner.nextInt());
            }
        }
    }
}