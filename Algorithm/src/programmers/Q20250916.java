package programmers;

public class Q20250916 {

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] rankBoard = new int[k];
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < score.length; i++) {
            if (i < k) {
                rankBoard[i] = score[i];

                if (min > score[i]) {
                    min = score[i];
                    minIndex = i;
                }

                answer[i] = min;
            } else {
                if (score[i] > min) {
                    rankBoard[minIndex] = score[i];
                    min = rankBoard[0];
                    minIndex = 0;

                    for (int j = 1; j < k; j++) {
                        if (min > rankBoard[j]) {
                            min = rankBoard[j];
                            minIndex = j;
                        }
                    }
                }
                answer[i] = min;
            }
        }

        return answer;
    }
}
