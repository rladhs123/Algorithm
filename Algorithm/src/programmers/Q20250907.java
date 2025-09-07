package programmers;

import java.util.ArrayList;
import java.util.List;

public class Q20250907 {

    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (student1[i % student1.length] == answers[i]) {
                answer[0]++;
            }
            if (student2[i % student2.length] == answers[i]) {
                answer[1]++;
            }
            if (student3[i % student3.length] == answers[i]) {
                answer[2]++;
            }
        }

        int max = answer[0];

        for (int i = 1; i < answer.length; i++) {
            if (answer[i] > max) {
                max = answer[i];
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == max) {
                list.add(i + 1);
            }
        }

        answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
