package programmers;

import java.util.Arrays;

public class Q20250921 {

    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        for (int i = score.length - m; i >= 0; i -= m) {
            answer += score[i] * m;
        }

        return answer;
    }
}
