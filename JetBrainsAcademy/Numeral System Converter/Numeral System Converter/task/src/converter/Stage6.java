package converter;

import java.util.Scanner;

public class Stage6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sr = scanner.nextLine();
        if (!sr.matches("([1-9]|[1-2][0-9]|[3][0-6])")) {
            System.out.println("Error. Invalid source radix: " + sr);
            System.exit(0);
        }
        int isr = Integer.parseInt(sr);

        String n = scanner.nextLine();

        if (!n.matches("^[a-zA-Z0-9.]*$")) {
            System.out.println("Error. Invalid number: " + n);
            System.exit(0);
        }

        String[] ss = n.split("\\.");

        if (isr != 1) {
            try {
                Integer.parseInt(ss[0], isr);
            } catch (Exception e) {
                System.out.println("Error. Invalid number: " + n);
                System.exit(0);
            }
        }

        String tr = scanner.nextLine();
        if (!tr.matches("([1-9]|[1-2][0-9]|[3][0-6])")) {
            System.out.println("Error. Invalid target radix: " + tr);
            System.exit(0);
        }
        int itr = Integer.parseInt(tr);

        String integerPart = convertIntegerPart(isr, ss[0], itr);
        String fractionalPart = "";
        if (ss.length > 1) {
            fractionalPart = convertFractionalPart(isr, ss[1], itr);
        }
        System.out.println(integerPart + fractionalPart);
    }

    private static String convertIntegerPart(int sr, String n, int tr) {
        int dn = (sr == 1) ? n.length() : Integer.parseInt(n, sr);
        StringBuilder sb = new StringBuilder();
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

        StringBuilder sb = new StringBuilder().append(".");
        for (int i = 0; i < 5; i++) {
            String[] split = String.valueOf(dv * tr).split("\\.");
            char c = Character.forDigit(Integer.parseInt(split[0]), tr);
            sb.append(c);
            dv = Double.parseDouble("0." + split[1]);
        }

        return sb.toString();
    }
}
