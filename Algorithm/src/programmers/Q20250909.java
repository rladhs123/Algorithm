package programmers;

import java.util.Stack;

public class Q20250909 {

    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(curr);
            } else if (stack.peek() == curr) {
                stack.pop();
            } else {
                stack.push(curr);
            }
        }

        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }
}
