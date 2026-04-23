package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q20260423 {

    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] arr = new int[emergency.length];

        for (int i = 0; i < emergency.length; i++) {
            arr[i] = emergency[i];
        }

        Arrays.sort(emergency);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < emergency.length; i++) {
            map.put(emergency[i], emergency.length - i);
        }

        for (int i = 0; i < emergency.length; i++) {
            answer[i] = map.get(arr[i]);
        }

        return answer;
    }
}
