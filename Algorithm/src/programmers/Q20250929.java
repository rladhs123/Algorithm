package programmers;

import java.util.Arrays;

public class Q20250929 {

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        float[] failRatio = new float[N];
        Arrays.sort(stages);
        //1 2 2 2 3 3 4 6

        for (int i = 1; i <= N; i++) {
            float nonePassedPlayer = 0;
            float passedPlayer = 0;

            for (int j = 0; j < stages.length; j++) {
                if (stages[j] > i) {
                    passedPlayer++;
                } else if (stages[j] == i) {
                    nonePassedPlayer++;
                    passedPlayer++;
                }
            }

            if (passedPlayer == 0) {
                failRatio[i - 1] = 0;
            } else {
                failRatio[i - 1] = nonePassedPlayer / passedPlayer;
            }

            System.out.print(failRatio[i - 1] + " ");
        }

        boolean[] isCheck = new boolean[N];

        for (int i = 0; i < N; i++) {
            float max = -1;
            int maxIndex = 0;
            for (int j = 0; j < N; j++) {
                if (failRatio[j] > max && !isCheck[j]) {
                    max = failRatio[j];
                    maxIndex = j;
                }
            }
            answer[i] = maxIndex + 1;
            isCheck[maxIndex] = true;
        }

        return answer;
    }
}
