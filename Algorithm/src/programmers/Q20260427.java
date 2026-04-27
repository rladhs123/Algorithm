package programmers;

import java.util.HashMap;
import java.util.Map;

public class Q20260427 {

    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        Map<String, Boolean> map = new HashMap<>();

        for (String s : spell) {
            map.put(s, false);
        }

        boolean b = false;

        for (String s : dic) {
            if (s.length() == spell.length) {
                for (int i = 0; i < s.length(); i++) {
                    if (map.containsKey(Character.toString(s.charAt(i)))) {
                        map.put(Character.toString(s.charAt(i)), true);
                    }
                }

                b = true;

                for (String key : map.keySet()) {
                    if (!map.get(key)) {
                        b = false;
                    }
                }
            }

            if (b) {
                answer = 1;
                break;
            } else {
                for (String key : map.keySet()) {
                    map.put(key, false);
                }
            }
        }

        return answer;
    }
}
