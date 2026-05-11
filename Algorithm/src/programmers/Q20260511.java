package programmers;

import java.util.HashSet;
import java.util.Set;

public class Q20260511 {

    public String solution(String my_string) {
        String answer = "";
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);

            if (set.contains(c)) {
                continue;
            }

            set.add(c);
            sb.append(c);
        }

        answer = sb.toString();

        return answer;
    }
}
