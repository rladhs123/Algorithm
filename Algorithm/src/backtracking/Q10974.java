package backtracking;

import java.util.Scanner;

public class Q10974 {

    static int N;
    static int[] array;
    static int[] result;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        array = new int[N];
        result = new int[N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            array[i] = i + 1;
        }

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                result[depth] = array[i];
                isVisited[i] = true;
                dfs(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
