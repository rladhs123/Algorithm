package leet;

import java.util.Arrays;

public class Q20260723 {

    public int singleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int result = nums[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (result == nums[i]) {
                count++;
            } else {
                if (count == 2) {
                    count = 1;
                    result = nums[i];
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
