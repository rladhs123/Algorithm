package leet;

import java.util.HashMap;
import java.util.Map;

public class Q20261004 {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int result = -1;
        int maxCount = 0;

        for (int num : map.keySet()) {
            int count = map.get(num);

            if (count > maxCount ||
                    (count == maxCount && num < result)) {
                result = num;
                maxCount = count;
            }
        }

        return result;
    }
}
