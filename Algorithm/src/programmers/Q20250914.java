package programmers;

import java.util.Arrays;

public class Q20250914 {

    public String solution(String s) {
        String answer = "";
        char[] array = s.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();

        for (int i = array.length - 1; i >= 0; i--) {
            sb.append(array[i]);
        }

        answer = sb.toString();
        return answer;
    }
}
