package programmers;

public class Q20260512 {

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nY = h + dy[i];
            int nX = w + dx[i];

            if (nY < 0 || nX < 0 || nY >= board.length || nX >= board.length) {
                continue;
            }

            if (board[nY][nX].equals(board[h][w])) {
                answer++;
            }
        }

        return answer;
    }
}
