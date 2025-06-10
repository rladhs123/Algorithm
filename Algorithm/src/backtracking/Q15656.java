package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Q15656 {

    static int N, M;
    static int[] array;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        array = new int[N];
        result = new int[M];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            result[depth] = array[i];
            dfs(depth + 1);
        }
    }
}
