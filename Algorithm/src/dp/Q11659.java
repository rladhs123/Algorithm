package dp;

import java.util.Scanner;

/**
 * 구간 합 구하기 4
 *
 * 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
 */
public class Q11659 {

    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[] array = new int[N];
        int[] dp = new int[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        dp[0] = array[0];

        for (int i = 1; i < N; i++) {
            dp[i] += dp[i - 1] + array[i];
        }

        for (int k = 0; k < M; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            sb.append(dp[j - 1] - dp[i - 1] + array[i - 1]).append('\n');
        }

        System.out.print(sb);
    }
}
