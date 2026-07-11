package leet;

import java.util.Arrays;

public class Q20260712 {

    public double minimumAverage(int[] nums) {
        int n = nums.length;
        double[] averages = new double[n / 2];
        Arrays.sort(nums);
        double result = Double.MAX_VALUE;

        for (int i = 0; i < n / 2; i++) {
            int minElement = nums[i];
            int maxElement = nums[n - i - 1];
            averages[i] = ((double)(minElement + maxElement) / 2);

            if (averages[i] < result) {
                result = averages[i];
            }
        }

        return result;
    }
}
