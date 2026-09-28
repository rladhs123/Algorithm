package leet;

import java.util.HashSet;
import java.util.Set;

public class Q20260928 {

    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        int result = -1;

        for (int num : nums2) {
            if (set.contains(num)) {
                result = num;
                break;
            }
        }

        return result;
    }
}
