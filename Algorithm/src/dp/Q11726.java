package dp;

import java.util.Scanner;

/**
 * 2*N 타일링
 *
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 */
public class Q11726 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] dp = new int[N];
        dp[0] = 1 % 10007;
        if (N >= 2) {
            dp[1] = 2 % 10007;

            for (int i = 2; i < N; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
            
            System.out.println(dp[N - 1]);
        } else {
            System.out.println(dp[0]);
        }


    }
}
