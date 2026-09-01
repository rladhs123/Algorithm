package leet;

import java.util.Arrays;

public class Q20260901 {

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] > nums[i - 1]) {
                int tmp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        return nums;
    }
}
