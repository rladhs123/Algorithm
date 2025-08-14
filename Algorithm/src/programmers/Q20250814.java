package programmers;

import java.util.Arrays;

public class Q20250814 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < answer.length; i++) {
            int[] slice = new int[commands[i][1] - commands[i][0] + 1];
            int index = 0;

            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                slice[index] = array[j];
                index++;
            }

            Arrays.sort(slice);
            answer[i] = slice[commands[i][2] - 1];
        }

        return answer;
    }
}
