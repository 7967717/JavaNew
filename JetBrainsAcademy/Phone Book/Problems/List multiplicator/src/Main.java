import java.util.List;

/**
 * Class to modify
 */
class ListMultiplicator {

    /**
     * Multiplies original list provided number of times
     *
     * @param list list to multiply
     * @param n    times to multiply, should be zero or greater
     */
    public static void multiply(List<?> list, int n) {
        custom(list, n);
    }

    private static <T> void custom(List<T> list, int n) {
        List<T> temp = new ArrayList<>(list);
        list.removeAll(temp);
        for (int i = 0; i < n; i++) {
            list.addAll(temp);
        }
    }
}