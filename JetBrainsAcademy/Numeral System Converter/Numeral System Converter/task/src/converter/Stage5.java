package converter;

import java.util.Scanner;

public class Stage5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sr = scanner.nextInt();
        String n = scanner.next();
        int tr = scanner.nextInt();

        String[] ss = n.split("\\.");

        String integerPart = convertIntegerPart(sr, ss[0], tr);
        String fractionalPart = "";
        if (ss.length > 1) {
            fractionalPart = "." + convertFractionalPart(sr, ss[1], tr);
        }
        System.out.println(integerPart + fractionalPart);
    }

    private static String convertIntegerPart(int sr, String n, int tr) {
        StringBuilder sb = new StringBuilder();

        int dn = (sr == 1) ? n.length() : Integer.parseInt(n, sr);
        if (tr == 1) {
            sb.append("1".repeat(dn));
        } else {
            sb.append(Integer.toString(dn, tr));
        }
        return sb.toString();
    }

    private static String convertFractionalPart(int sr, String n, int tr) {
        double dv = 0;
        char[] chars = n.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            double num = Character.getNumericValue(chars[i]);
            dv += num / Math.pow(sr, i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            String[] split = String.valueOf(dv * tr).split("\\.");
            char c = Character.forDigit(Integer.parseInt(split[0]), tr);
            sb.append(c);
            dv = Double.parseDouble("0." + split[1]);
        }

        return sb.toString();
    }
}
