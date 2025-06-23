package dp;

import java.util.Scanner;

public class Q9461 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] indexArray = new int[T];
        int maxIndex = -1;

        for (int i = 0; i < T; i++) {
            indexArray[i] = sc.nextInt();

            if (indexArray[i] > maxIndex) {
                maxIndex = indexArray[i];
            }
        }

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i <= maxIndex; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        for (int i = 0; i < T; i++) {
            System.out.println(dp[indexArray[i]]);
        }
    }
}
