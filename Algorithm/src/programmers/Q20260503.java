package programmers;

import java.util.Arrays;

public class Q20260503 {

    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        answer = array[array.length / 2];
        return answer;
    }
}
