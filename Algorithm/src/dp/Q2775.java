package dp;

import java.util.Scanner;

public class Q2775 {

    static int T, K, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        int[][] map = new int[15][15];

        for (int i = 1; i <= 14; i++) {
            map[0][i] = i;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                for (int k = 1; k <= j; k++) {
                    map[i][j] += map[i - 1][k];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            K = sc.nextInt();
            N = sc.nextInt();

            sb.append(map[K][N]).append('\n');
        }

        System.out.print(sb);
    }
}
