package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 수 정렬하기 4
 *
 * N개의 수가 주어졌을 때, 이를 내림차순으로 정렬하는 프로그램을 작성하시오.
 */
public class Q11931 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();
        for (int i = N - 1; i >= 0; i--) {
            sb.append(array[i]).append('\n');
        }

        System.out.print(sb);
    }
}
