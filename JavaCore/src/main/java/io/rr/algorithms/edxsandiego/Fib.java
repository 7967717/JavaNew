package io.rr.algorithms.edxsandiego;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Stream;

public class Fib {
    public static void main(String[] args) {
        System.out.println("Max int " + Integer.MAX_VALUE);
        System.out.println("Max long " + Long.MAX_VALUE);

        System.out.println();
        System.out.println(fibLastDigitNaive(0));
        System.out.println(fibLastDigitNaive(1));
        System.out.println(fibLastDigitNaive(2));
        System.out.println(fibLastDigitNaive(3));
        System.out.println(fibLastDigitNaive(50));
        System.out.println(fibLastDigitNaive(100));

        System.out.println();
        System.out.println(fibStream(0));
        System.out.println(fibStream(1));
        System.out.println(fibStream(2));
        System.out.println(fibStream(3));
        System.out.println(fibStream(50));
        System.out.println(fibStream(100));

        System.out.println();
        System.out.println(fibN(0));
        System.out.println(fibN(1));
        System.out.println(fibN(2));
        System.out.println(fibN(3));
        System.out.println(fibN(20));
        System.out.println(fibN(50));
        System.out.println(fibN(100));

        System.out.println();
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(20));
    }

    private static BigInteger fibLastDigitNaive(int n) {
        if (n <= 1)
            return BigInteger.valueOf(n);

        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;

        for (int i = 0; i < n - 1; ++i) {
            BigInteger tmp_previous = previous;
            previous = current;
            current = tmp_previous.add(current);
        }

        return current;
    }

    static BigInteger fibN(int n) {
        if (n <= 1) return BigInteger.valueOf(n);

        BigInteger[] arr = new BigInteger[n + 1];
        arr[0] = BigInteger.ZERO;
        arr[1] = BigInteger.ONE;
        for (int j = 2; j <= n; j++) {
            arr[j] = arr[j - 1].add(arr[j - 2]);
        }
        return arr[n];
    }

    static long fib(long i) {
        if (i <= 1) return i;
        else return (fib(i - 1) + fib(i - 2));
    }

    static BigInteger fibStream(int n) {
        Optional<BigInteger> res =
                Stream.iterate(new BigInteger[]{BigInteger.ZERO, BigInteger.ONE}, x -> new BigInteger[]{x[1], x[0].add(x[1])})
                        .limit(n + 1)
                        .map(x -> x[0])
                        .reduce((a, b) -> b);
        return res.orElse(null);
    }
}
