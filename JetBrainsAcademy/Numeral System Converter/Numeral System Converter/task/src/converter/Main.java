package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sr = scanner.nextInt();
        String n = scanner.next();
        int tr = scanner.nextInt();

        int dn = sr == 1 ? n.length() : Integer.parseInt(n, sr);
        StringBuffer sb = new StringBuffer();
        if (tr == 1) {
            sb.append("1".repeat(Math.max(0, dn)));
        } else {
            sb.append(Integer.toString(dn, tr));
        }
        System.out.println(sb.toString());
    }
}
