package backtracking;

import java.util.Arrays;
import java.util.Scanner;

/**
 * N과M (8)
 * <p>
 * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * N개의 자연수는 모두 다른 수이다.
 * N개의 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 고른 수열은 비내림차순이어야 한다.
 * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
 */
public class Q15657 {

    static int N, M;
    static int[] array, result;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        array = new int[N];
        result = new int[M];
        isVisited = new boolean[N];

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        backTracking(0, 0);

        System.out.println(sb);
    }

    static void backTracking(int depth, int index) {
        if (depth == M) {
            for (int i : result) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < array.length; i++) {
            result[depth] = array[i];
            backTracking(depth + 1, i);
        }
    }
}
