package graph.dfs;

import java.util.Scanner;

/**
 * 내리막 길
 *
 * 여행을 떠난 세준이는 지도를 하나 구하였다.
 * 이 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다.
 * 한 칸은 한 지점을 나타내는데 각 칸에는 그 지점의 높이가 쓰여 있으며,
 * 각 지점 사이의 이동은 지도에서 상하좌우 이웃한 곳끼리만 가능하다.
 * 지도가 주어질 때 이와 같이 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지
 * 항상 내리막길로만 이동하는 경로의 개수를 구하는 프로그램을 작성하시오.
 */
public class Q1520 {

    static int M, N, count;
    static int[][] map, dp;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int y, int x) {
        if (y == M - 1 && x == N - 1) {
            return 1;
        }

        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY >= 0 && nextX >= 0 && nextY < M && nextX < N) {
                if (map[y][x] > map[nextY][nextX]) {
                    dp[y][x] += dfs(nextY, nextX);
                }
            }
        }

        return dp[y][x];
    }
}
