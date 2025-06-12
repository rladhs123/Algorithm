package graph.dfs;

import java.util.Scanner;

public class Q14716 {

    static int M, N;
    static int[][] map;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static boolean[][] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        isVisited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int result = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    dfs(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static void dfs(int y, int x) {
        for (int i = 0; i < 8; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];

            if (nY >= 0 && nX >= 0 && nY < M && nX < N) {
                if (!isVisited[nY][nX] && map[nY][nX] == 1) {
                    isVisited[nY][nX] = true;
                    dfs(nY, nX);
                }
            }
        }
    }
}
