package dp;

import java.util.Scanner;

/**
 * 이동하기
 *
 * 준규는 N×M 크기의 미로에 갇혀있다. 미로는 1×1크기의 방으로 나누어져 있고, 각 방에는 사탕이 놓여져 있다.
 * 미로의 가장 왼쪽 윗 방은 (1, 1)이고, 가장 오른쪽 아랫 방은 (N, M)이다.
 * 준규는 현재 (1, 1)에 있고, (N, M)으로 이동하려고 한다. 준규가 (r, c)에 있으면,
 * (r+1, c), (r, c+1), (r+1, c+1)로 이동할 수 있고,
 * 각 방을 방문할 때마다 방에 놓여져있는 사탕을 모두 가져갈 수 있다. 또, 미로 밖으로 나갈 수는 없다.
 * 준규가 (N, M)으로 이동할 때, 가져올 수 있는 사탕 개수의 최댓값을 구하시오.
 */
public class Q11048 {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = map[i][j];
                    continue;
                }

                if (i == 0) {
                    dp[i][j] = map[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = map[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = map[i][j] + Math.max(Math.max(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}