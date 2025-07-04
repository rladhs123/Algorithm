package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Q15666 {

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

        dfs(0, 0);

        System.out.print(sb);
    }

    static void dfs(int depth, int index) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prev = -1;

        for (int i = index; i < N; i++) {
            if (prev == array[i]) {
                continue;
            }

            result[depth] = array[i];
            prev = array[i];
            dfs(depth + 1, i);
        }
    }
}
