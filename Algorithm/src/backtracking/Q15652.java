package backtracking;

import java.util.Scanner;

/**
 * N과M (4)
 *
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 고른 수열은 비내림차순이어야 한다.
 * (길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.)
 */
public class Q15652 {

    static int N;
    static int M;
    static int[] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        array = new int[M];
        int count = 0;

        backTracking(count, 1);
    }

    static void backTracking(int count, int index) {
        if (count == M) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i <= N; i++) {
            array[count] = i;
            backTracking(count + 1, i);
        }
    }
}
