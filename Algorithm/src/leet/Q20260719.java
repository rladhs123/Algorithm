package leet;

import java.util.List;

public class Q20260719 {

    public int countPairs(List<Integer> nums, int target) {
        int result = 0;

        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    result++;
                }
            }
        }

        return result;
    }
}
