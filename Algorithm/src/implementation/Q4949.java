package implementation;

import java.util.Scanner;
import java.util.Stack;

public class Q4949 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = sc.nextLine();
            Stack<Character> stack = new Stack<>();

            if (input.equals(".")) {
                break;
            }

            boolean check = true;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c == '('  || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == ']') {
                    if (stack.isEmpty()) {
                        check = false;
                        break;
                    }

                    char top = stack.pop();
                    if ((c == ')' && top != '(') || (c == ']' && top != '[')) {
                        check = false;
                        break;
                    }
                }
            }

            if (check && stack.isEmpty()) {
                sb.append("yes");
            } else {
                sb.append("no");
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
