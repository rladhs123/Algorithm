package programmers;

import java.util.Arrays;

public class Q20250821 {

    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int sum = 0;

        for (int i = 0; i < d.length; i++) {
            if (sum + d[i] <= budget) {
                sum += d[i];
                answer++;
            }
        }
        return answer;
    }
}
