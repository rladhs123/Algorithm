package leet;

import java.util.*;

public class Q20260808 {

    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i : nums) {
            set.add(i);
        }

        for (int i = nums[0]; i <= nums[nums.length - 1]; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }

        return list;
    }
}
