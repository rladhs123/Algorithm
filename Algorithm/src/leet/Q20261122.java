package leet;

import java.util.HashMap;
import java.util.Map;

public class Q20261122 {

    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        int index = 0;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);

            if (c != ' ' && !map.containsKey(c)) {
                map.put(c, (char) ('a' + index));
                index++;
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            if (c == ' ') {
                result.append(' ');
            } else {
                result.append(map.get(c));
            }
        }

        return result.toString();
    }
}
