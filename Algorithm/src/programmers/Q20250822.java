package programmers;

import java.util.HashMap;
import java.util.Map;

public class Q20250822 {
    public int solution(String s) {
        int answer = 0;
        Map<String, String> map = new HashMap<>();
        String[] array = {"zero", "one", "two", "three", "four",
                        "five", "six", "seven", "eight", "nine"};
        String word = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            map.put(array[i], Integer.toString(i));
        }

        for (int i = 0; i < s.length(); i++) {
            word += Character.toString(s.charAt(i));
            if (map.containsKey(word)) {
                sb.append(map.get(word));
                word = "";
            } else if (map.containsValue(word)) {
                sb.append(word);
                word = "";
            }
        }

        answer = Integer.parseInt(sb.toString());
        
        return answer;
    }
}
