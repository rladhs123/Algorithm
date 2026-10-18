package leet;

import java.util.Arrays;

public class Q20261018 {

    public int findNonMinOrMax(int[] nums) {
        if (nums.length <= 2) {
            return -1;
        }

        Arrays.sort(nums);

        return nums[nums.length - 2];
    }
}
