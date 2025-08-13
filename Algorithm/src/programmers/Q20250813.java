package programmers;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Q20250813 {

    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }

        answer = new int[set.size()];
        int index = 0;

        for (Integer i : set) {
            answer[index] = i;
            index++;
        }

        Arrays.sort(answer);

        return answer;
    }
}
