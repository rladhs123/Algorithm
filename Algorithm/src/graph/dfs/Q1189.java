package graph.dfs;

import java.util.Scanner;

public class Q1189 {

    static int R, C, K;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int result;
    static boolean[][] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        map = new char[R][C];
        isVisited = new boolean[R][C];
        sc.nextLine();

        for (int i = 0; i < R; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        isVisited[R - 1][0] = true;
        dfs(0, R - 1, 0);

        System.out.println(result);
    }

    static void dfs(int depth, int y, int x) {
        if (depth == K - 1 && y == 0 && x == C - 1) {
            result++;
        }

        for (int i = 0; i < 4; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];

            if (nY >= 0 && nX >= 0 && nY < R && nX < C) {
                if (!isVisited[nY][nX] && map[nY][nX] == '.') {
                    isVisited[nY][nX] = true;
                    dfs(depth + 1, nY, nX);
                    isVisited[nY][nX] = false;
                }
            }
        }
    }
}
