package leet;

import java.util.HashMap;
import java.util.Map;

public class Q20260909 {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int result = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                result = i;
                break;
            }
        }

        return result;
    }
}
