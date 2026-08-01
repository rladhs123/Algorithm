package leet;

import java.util.Arrays;

public class Q20260801 {

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);

        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
