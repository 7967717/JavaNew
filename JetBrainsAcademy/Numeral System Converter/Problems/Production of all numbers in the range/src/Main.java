import java.util.function.*;


class Operator {
    public static LongBinaryOperator binaryOperator = (x, y) -> {
        long res = x;
        for (long i = ++x; i <= y; i++) {
            res = res * i;
        }
        return res;
    };
}