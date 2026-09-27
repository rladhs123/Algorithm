package leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q20260927 {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Float> set = new HashSet<>();
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            set.add((float)(nums[start] + nums[end]) / 2);
            start++;
            end--;
        }

        return set.size();
    }
}
