package leet;

import java.util.HashMap;
import java.util.Map;

public class Q20260725 {

    public char findTheDifference(String s, String t) {
        char result = ' ';
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            int count = map.getOrDefault(curr, 0) - 1;

            if (count < 0) {
                result = curr;
                break;
            }

            map.put(curr, count);
        }

        return result;
    }
}
