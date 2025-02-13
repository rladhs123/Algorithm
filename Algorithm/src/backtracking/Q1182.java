package backtracking;

import java.util.Scanner;

/**
 * N개의 정수로 이루어진 수열이 있을 때,
 * 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이
 * S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 */
public class Q1182 {

    static int N;
    static int S;
    static int[] array;
    static int sum;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        backTracking(0, 0);
        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    static void backTracking(int sum, int index) {
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        backTracking(sum + array[index], index + 1); //현재 값 포함
        backTracking(sum, index + 1); //현재 값 포함x
    }
}
