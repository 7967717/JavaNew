
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        String[] levels = scanner.nextLine().trim().toUpperCase().split("\\s+");
        for (String s : levels) {
            Level level;
            switch (s) {
                case "SEVERE":
                    level = Level.SEVERE;
                    break;
                case "WARNING":
                    level = Level.WARNING;
                    break;
                case "INFO":
                    level = Level.INFO;
                    break;
                case "CONFIG":
                    level = Level.CONFIG;
                    break;
                case "FINE":
                    level = Level.FINE;
                    break;
                case "FINER":
                    level = Level.FINER;
                    break;
                case "FINEST":
                    level = Level.FINEST;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + s);
            }
            int value = level.intValue();
            res += value;
        }
        System.out.println(res);
    }
}