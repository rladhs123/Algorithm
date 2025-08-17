package programmers;

import java.util.HashMap;
import java.util.Map;

public class Q20250817 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            if (map.containsKey(participant[i])) {
                map.replace(participant[i], map.get(participant[i]) + 1);
            } else {
                map.put(participant[i], 1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            if (map.containsKey(completion[i])) {
                map.replace(completion[i], map.get(completion[i]) - 1);
            }
        }

        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                answer = s;
            }
        }
        return answer;
    }
}
