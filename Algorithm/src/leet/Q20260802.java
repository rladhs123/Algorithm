package leet;

import java.util.HashSet;
import java.util.Set;

public class Q20260802 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }

        return false;
    }
}
