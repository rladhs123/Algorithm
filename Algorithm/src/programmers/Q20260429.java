package programmers;

public class Q20260429 {

    public int solution(int[][] board) {
        int answer = 0;
        int size = board[0].length;
        int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < dy.length; k++) {
                        int y = i + dy[k];
                        int x = j + dx[k];

                        if (y >= 0 && x >= 0 && y < size && x < size) {
                            if (board[y][x] == 0) {
                                board[y][x] = 2;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
