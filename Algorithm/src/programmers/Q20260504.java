package programmers;

import java.util.Arrays;

public class Q20260504 {

    public int solution(int[] array, int n) {
        int answer = 0;
        Arrays.sort(array);
        int gap = 123456789;

        for (int i : array) {
            if (Math.abs(n - i) < gap) {
                answer = i;
                gap = Math.abs(n - i);
            }
        }

        return answer;
    }
}
