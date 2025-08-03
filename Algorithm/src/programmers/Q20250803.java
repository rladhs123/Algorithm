package programmers;

public class Q20250803 {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && !isVisited[j]) {
                    dfs(i, computers, isVisited);
                    answer++;
                }
            }
        }

        return answer;
    }

    static void dfs(int n, int[][] computers, boolean[] isVisited) {
        isVisited[n] = true;

        for (int i = 0; i < computers[n].length; i++) {
            if (computers[n][i] == 1 && !isVisited[i]) {
                dfs(i, computers, isVisited);
            }
        }
    }
}
