package programmers;

import java.util.HashSet;
import java.util.Set;

public class Q20260428 {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        char prev = words[0].charAt(words[0].length() - 1);
        int turn = 1;
        int player = 1;
        int count = 1;

        for (int i = 1; i < words.length; i++) {
            turn = (n + i) / n;
            player = i % n;
            String word = words[i];

            if (word.charAt(0) != prev) {
                break;
            } else if(set.contains(word)) {
                break;
            }

            set.add(word);
            prev = word.charAt(word.length() - 1);
            count++;
        }

        if (count == words.length) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = player + 1;
            answer[1] = turn;
        }

        return answer;
    }
}
