package leet;

import java.util.Arrays;

public class Q20261010 {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int result = Math.max(
                nums[size - 1] * nums[size - 2] * nums[size - 3],
                nums[0] * nums[1] * nums[size - 1]);

        return result;
    }
}
