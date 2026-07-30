package leet;

import java.util.HashMap;
import java.util.Map;

public class Q20260730 {

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int result = 0;

        for (Integer i : map.keySet()) {
            if (map.get(i) == 1) {
                result += i;
            }
        }

        return result;
    }
}
