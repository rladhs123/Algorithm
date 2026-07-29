package leet;

import java.util.Arrays;

public class Q20260729 {

    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] expected = new int[n];

        for (int i = 0; i < n; i++) {
            expected[i] = heights[i];
        }

        Arrays.sort(heights);
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (expected[i] != heights[i]) {
                result++;
            }
        }

        return result;
    }
}
