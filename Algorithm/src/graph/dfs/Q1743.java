package graph.dfs;

import java.util.Scanner;

/**
 * 음식물 피하기
 *
 * 음식물들은 근처에 있는 것끼리 뭉치게 돼서 큰 음식물 쓰레기가 된다.
 * 떨어진 음식물 중에 제일 큰 음식물만은 피해 가려고 한다.
 * 제일 큰 음식물의 크기를 구하자.
 */
public class Q1743 {

    static int N, M, K, count;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            map[r - 1][c - 1] = 1;
        }

        int max = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    max = Math.max(count, max);
                    count = 0;
                }
            }
        }

        System.out.println(max);
    }

    static void dfs(int r, int c) {
        count++;
        isVisited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dy[i];
            int nextC = c + dx[i];

            if (nextR >= 0 && nextC >= 0 && nextR < N && nextC < M) {
                if (!isVisited[nextR][nextC] && map[nextR][nextC] == 1) {
                    dfs(nextR, nextC);
                }
            }
        }
    }
}
