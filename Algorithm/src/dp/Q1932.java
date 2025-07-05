package dp;

import java.util.Scanner;

public class Q1932 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] array = new int[N][N];
        int[][] dp = new int[N][N];
        
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                array[i - 1][j] = sc.nextInt();
            }
        }

        dp[0][0] = array[0][0];
        int max = dp[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + array[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + array[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + array[i][j];
                }

                if (i == N - 1) {
                    if (j == 0) {
                        max = dp[i][j];
                    } else {
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }

        System.out.println(max);
    }
}
