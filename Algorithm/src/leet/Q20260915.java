package leet;

import java.util.Arrays;

public class Q20260915 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        int result = nums[0];
        int count = 1;
        int k = nums.length / 2;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                prev = nums[i];
                result = nums[i];
                count = 1;
                continue;
            }

            count++;

            if (count > k) {
                result = prev;
                break;
            }
        }

        return result;
    }
}
