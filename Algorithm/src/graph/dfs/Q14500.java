package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {

    static int N, M;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int max = 0;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isVisited[i][j] = true;
                dfs(0, i, j, map[i][j]);
                isVisited[i][j] = false;
                cal(i, j);
            }
        }

        System.out.println(max);
    }

    static void dfs(int depth, int y, int x, int score) {
        if (depth == 3) {
            if (score > max) {
                max = score;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];

            if (nY < 0 || nX < 0 || nY >= N || nX >= M) {
                continue;
            }

            if (isVisited[nY][nX]) {
                continue;
            }

            isVisited[nY][nX] = true;
            dfs(depth + 1, nY, nX, score + map[nY][nX]);
            isVisited[nY][nX] = false;
        }
    }

    static void cal(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];

            if (nY < 0 || nX < 0 || nY >= N || nX >= M ) {
                continue;
            }

            int sum = map[y][x];

            if (nY == y) {
                if (nY - 1 >= 0 && nY + 1 < N) {
                    sum += map[nY][nX] + map[nY - 1][nX] + map[nY + 1][nX];
                }
            } else {
                if (nX - 1 >= 0 && nX + 1 < M) {
                    sum += map[nY][nX] + map[nY][nX - 1] + map[nY][nX + 1];
                }
            }

            if (sum > max) {
                max = sum;
            }
        }
    }
}
