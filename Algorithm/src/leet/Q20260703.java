package leet;

import java.util.List;
import java.util.Stack;

public class Q20260703 {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] arr = log.split(":");

            int id = Integer.parseInt(arr[0]);
            String type = arr[1];
            int time = Integer.parseInt(arr[2]);

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += time - prevTime;
                }

                stack.push(id);
                prevTime = time;
            } else {
                result[stack.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }

        return result;
    }
}
