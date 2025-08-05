package programmers;

public class Q20250805 {

    public int solution(int n, int w, int num) {
        int answer = 0;
        int[][] box = new int[n / w + 1][w];
        int targetY = 0;
        int targetX = 0;
        int count = 1;

        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < w; j++) {

                if (i % 2 == 0) {
                    if (count == num) {
                        targetY = i;
                        targetX = j;
                    }
                    box[i][j] = count;
                } else {
                    if (count == num) {
                        targetY = i;
                        targetX = w - (j + 1);
                    }
                    box[i][w - (j + 1)] = count;
                }

                count++;
            }
        }

        for (int i = box.length - 1; i >= 0; i--) {
            for (int j = 0; j < w; j++) {
                if (box[i][j] <= n && j == targetX && i >= targetY) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
