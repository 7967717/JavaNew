import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine().trim();
        String[] s = line.split("\\s+");
        System.out.println(s[0].equals("") ? 0 : s.length);
        reader.close();
    }
}