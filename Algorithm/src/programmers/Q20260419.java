package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q20260419 {

    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        Arrays.sort(numlist);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < answer.length; i++) {
            int gap = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < answer.length; j++) {
                if (Math.abs(n - numlist[j]) <= gap && !set.contains(numlist[j])) {
                    gap = n - numlist[j];
                    index = j;
                }
            }

            answer[i] = numlist[index];
            set.add(numlist[index]);
        }

        return answer;
    }
}
