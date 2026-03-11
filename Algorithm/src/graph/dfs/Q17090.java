package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17090 {

    static int N, M;
    static char[][] map;
    static boolean[][] isVisited;
    static boolean[][] isRightRoute;
    static boolean check;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        isVisited = new boolean[N][M];
        isRightRoute = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j]) {
                    check = false;
                    dfs(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isRightRoute[i][j]) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static void dfs(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= M || isRightRoute[r][c]) {
            check = true;
            return;
        }

        if (!isVisited[r][c]) {
            isVisited[r][c] = true;

            if (map[r][c] == 'U') {
                dfs(r - 1, c);
            } else if (map[r][c] == 'R') {
                dfs(r, c + 1);
            } else if (map[r][c] == 'D') {
                dfs(r + 1, c);
            } else {
                dfs(r, c - 1);
            }

            if (check) {
                isRightRoute[r][c] = true;
            }
        }
    }
}
