package dp;

import java.util.Scanner;

public class Q24416 {

    static int callFunc, callDp;

    static int fib(int n) {
        if (n <= 2 && n > 0) {
            callFunc++;
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    static void fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            callDp++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        fib(N);
        fibonacci(N);

        System.out.println(callFunc + " " + callDp);
    }
}
