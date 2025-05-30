package dp;

import java.util.*;

/**
 * 1로 만들기 2
 *
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * 2. X가 2로 나누어 떨어지면, 2로 나눈다.
 * 3. 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 */
public class Q12852 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] dp = new int[N + 1];
        int[] from = new int[N + 1];
        StringBuilder sb = new StringBuilder();

        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            from[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                from[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                from[i] = i / 3;
            }
        }

        sb.append(dp[N] + "\n");

        List<Integer> path = new ArrayList<>();
        int curr = N;

        while (curr > 0) {
            path.add(curr);
            curr = from[curr];
        }

        for (Integer i : path) {
            sb.append(i + " ");
        }

        System.out.print(sb);
    }
}
