package backtracking;

import java.util.*;

/**
 * N과 M (9)
 * <p>
 * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * (N개의 자연수 중에서 M개를 고른 수열)
 */
public class Q15663 {

    static int N, M;
    static int[] array;
    static int[] result;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        array = new int[N];
        result = new int[M];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        dfs(0, 0);

        System.out.print(sb);
    }

    static void dfs(int depth, int index) {
        if (depth == M) {
            for (int i : result) {
                sb.append(i + " ");
            }

            sb.append('\n');
            return;
        }

        int last = -1;
        for (int i = 0; i < N; i++) {
            if (!isVisited[i] && last != array[i]) {
                isVisited[i] = true;
                result[depth] = array[i];
                last = array[i];
                dfs(depth + 1, i);
                isVisited[i] = false;
            }
        }
    }
}
