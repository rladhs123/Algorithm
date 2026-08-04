package programmers;

import java.util.HashMap;
import java.util.Map;

public class Q20260804 {

    public String solution(String letter) {
        String answer = "";
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<String, Character> map = new HashMap<>();

        for (int i = 0; i < morse.length; i++) {
            map.put(morse[i], (char) ('a' + i));
        }

        String[] arr = letter.split(" ");

        for (String s : arr) {
            answer += map.get(s);
        }

        return answer;
    }
}
