package io.rr.other;

public class ConsecutiveSequence {

    public String convert(int in) {
        String input = String.valueOf(in);
        if (input.length() <= 1 ) {
            throw new WrongNumberException();
        }

        int[] ints = input.chars().map(c -> c - '0').toArray();
        for (int anInt : ints) {
            if (anInt < 1 || anInt > 7) {
                throw new WrongNumberException();
            }
        }

        StringBuilder res = new StringBuilder();

        int i = 0, j;
        do {
            j = i + 1;
            while (j < ints.length) {
                if (ints[j] - ints[i] != j - i)
                    break;
                j++;
            }
            if (i == j - 1) {
                res.append(ints[i]).append(",");
            } else {
                res.append(ints[i]).append("-").append(ints[j - 1]).append(",");
            }
            i = j;
        } while (i < ints.length);
        res.replace(res.length() - 1, res.length(), "");

        return res.toString();
    }

    class WrongNumberException extends RuntimeException {
        public WrongNumberException() {
        }

        public WrongNumberException(String message) {
            super(message);
        }
    }

}

//        Given a number (Integer) where each digit is in range
//        1..7 according to the day of week (1 - Monday, 2 -
//        Tuesday... 7 -Sunday).
//        E.g. 126 - means Monday, Tuesday and Saturday.
//        Convert this number to the string, separating each digit
//        with ‘,’ for non consecutive sequence days, or ‘-’ for
//        consecutive sequence days.

//        Examples:
//        123 -> ‘1-3’
//        135 -> ‘1,3,5’
//        125 -> ‘1-2,5’
//        12367 -> ‘1-3,6-7’
//        134567 -> ‘1,3-7’
//        At least one digit <1 or >7 -> error