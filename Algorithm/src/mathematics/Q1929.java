package mathematics;

import java.util.Scanner;

public class Q1929 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        boolean[] prime = new boolean[N + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (prime[i]) continue;

            for (int j = i * i; j <= N; j += i) {
                prime[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = M; i <= N; i++) {
            if (!prime[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb);
    }
}
