import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = new char[50];
        reader.read(chars);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; chars[i] != '\u0000'; i++) {
            stack.push(chars[i]);
        }
        int s = stack.size();
        for (int i = 0; i < s; i++) {
            System.out.print(stack.pop());
        }
        reader.close();
    }
}