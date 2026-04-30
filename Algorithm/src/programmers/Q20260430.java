package programmers;

import java.util.HashMap;
import java.util.Map;

public class Q20260430 {

    public int solution(String before, String after) {
        int answer = 1;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < before.length(); i++) {
            char c = before.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < after.length(); i++) {
            char c = after.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }

        for (char c : map.keySet()) {
            if (map.get(c) != 0) {
                answer = 0;
                break;
            }
        }

        return answer;
    }
}
