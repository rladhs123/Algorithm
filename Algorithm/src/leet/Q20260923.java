package leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q20260923 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        boolean result = true;

        for (int key : map.keySet()) {
            if (set.contains(map.get(key))) {
                result = false;
            }

            set.add(map.get(key));
        }

        return result;
    }
}
