package leet;

import java.util.Stack;

public class Q20260702 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                stack.push(number);
            } catch (NumberFormatException e) {
                int a = stack.pop();
                int b = stack.pop();

                int value = 0;

                if (token.equals("+")) {
                    value = b + a;
                } else if (token.equals("-")) {
                    value = b - a;
                } else if (token.equals("*")) {
                    value = b * a;
                } else {
                    value = b / a;
                }

                stack.push(value);
            }
        }

        return stack.pop();
    }
}
