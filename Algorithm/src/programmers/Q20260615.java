package programmers;

import java.util.ArrayList;
import java.util.List;

public class Q20260615 {

    public int[] solution(int n, int[] numlist) {
        int[] answer;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] % n == 0) {
                list.add(numlist[i]);
            }
        }

        answer = new int[list.size()];
        int index = 0;

        for (int i : list) {
            answer[index] = i;
            index++;
        }

        return answer;
    }
}
