import java.util.*;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().trim().toCharArray();

        System.out.println(check(chars));
    }

    private static boolean check(char[] chars) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            String s = String.valueOf(c);
            if ("({[".contains(s)) {
                stack.offerLast(c);
            } else {
                if (stack.isEmpty() || ")}]".indexOf(s) != "({[".indexOf(stack.pollLast())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}