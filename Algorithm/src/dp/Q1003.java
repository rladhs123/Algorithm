package dp;

import java.util.Scanner;

/**
 * 피보나치 함수
 *
 * N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
 */
public class Q1003 {

    static int T, N;
    static int[][] dp = new int[2][41];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();
        dp[0][0] = 1;
        dp[1][1] = 1;

        for (int i = 0; i < T; i++) {
            N = sc.nextInt();

            for (int j = 2; j <= N; j++) {
                dp[0][j] = dp[0][j - 2] + dp[0][j - 1];
                dp[1][j] = dp[1][j - 2] + dp[1][j - 1];
            }

            sb.append(dp[0][N]).append(' ').append(dp[1][N]).append('\n');
        }

        System.out.println(sb);
    }
}
