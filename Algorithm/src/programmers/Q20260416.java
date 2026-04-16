package programmers;

import java.util.*;

public class Q20260416 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(((o1, o2) -> map.get(o2).compareTo(map.get(o1))));

        for (int i : list) {
            if (k <= 0) {
                break;
            }

            answer++;
            k -= map.get(i);
        }

        return answer;
    }
}
