package mathematics;

import java.util.Scanner;

/**
 * 다리놓기
 */
public class Q1010 {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            //M개 중 N개 고르기
            int result = combination(M, N);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static int combination(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    };
}
