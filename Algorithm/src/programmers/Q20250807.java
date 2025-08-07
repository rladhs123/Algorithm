package programmers;

import java.util.Arrays;

public class Q20250807 {

    public long solution(long n) {
        long answer = 0;

        String[] numbers = Long.toString(n).split("");
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            answer += (long) (Long.parseLong(numbers[i]) * Math.pow(10, i));
        }

        return answer;
    }
}
