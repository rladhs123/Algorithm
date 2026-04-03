package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        long mod = 10007;

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                }
            }
        }

        long result = 0;

        for (int i = 0; i < 10; i++) {
            result = (result + dp[n][i]) % mod;
        }

        System.out.println(result);
    }
}
