package programmers;

import java.util.HashMap;
import java.util.Map;

public class Q20260502 {

    public int solution(int[] array, int n) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        if (map.containsKey(n)) {
            answer = map.get(n);
        }

        return answer;
    }
}
