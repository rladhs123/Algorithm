package backtracking;

import java.io.BufferedReader;
import java.util.Scanner;

/**
 * N과M (3)
 *
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 */
public class Q15651 {

    static int N, M;
    static int[] array;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();
        array = new int[M];

        backTracking(0);
        System.out.println(sb);
    }

    static void backTracking(int depth) {
        if (depth == M) {
            for (int i : array) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            array[depth] = i + 1;
            backTracking(depth + 1);
        }
    }
}
