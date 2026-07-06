package leet;

import java.util.Stack;

public class Q20260706 {

    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i <= size; i++) {
            int currentHeights = (i == size) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeights < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                max = Math.max(max, height * width);
            }

            stack.push(i);
        }

        return max;
    }
}
