package graph.dfs;

import java.util.Scanner;

public class Q1245 {

    static int N, M;
    static int[][] map;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean[][] isVisited;
    static boolean top;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j] && map[i][j] != 0) {
                    top = true;
                    dfs(i, j);
                    if (top) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];

            if (nY >= 0 && nX >= 0 && nY < N && nX < M) {
                if (!isVisited[nY][nX] && map[y][x] == map[nY][nX]) {
                    dfs(nY, nX);
                } else if (map[nY][nX] > map[y][x]) {
                    top = false;
                }

            }
        }
    }
}
