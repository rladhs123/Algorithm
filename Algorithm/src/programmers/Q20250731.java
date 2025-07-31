package programmers;

import java.util.Stack;

public class Q20250731 {

    static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = answer.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = stack.peek();
            }

            stack.push(numbers[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[] {1, 3, 3, 5});
    }
}
