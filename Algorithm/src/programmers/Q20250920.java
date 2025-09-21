package programmers;

import java.util.HashMap;
import java.util.Map;

public class Q20250920 {

    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String s : callings) {
            int nextIndex = map.get(s) - 1;
            String front = players[nextIndex];

            players[nextIndex] = s;
            players[map.get(s)] = front;

            map.put(s, nextIndex);
            map.put(front, nextIndex + 1);
        }
        return players;
    }
}
