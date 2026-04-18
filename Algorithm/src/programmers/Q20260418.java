package programmers;

import java.util.HashMap;
import java.util.Map;

public class Q20260418 {

    public int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int max = 0;

        for (Integer i : map.keySet()) {
            if (map.get(i) > max) {
                max = map.get(i);
                answer = i;
            }
        }

        for (Integer i : map.keySet()) {
            if (map.get(i) == max && i != answer) {
                answer = -1;
                break;
            }
        }

        return answer;
    }
}
