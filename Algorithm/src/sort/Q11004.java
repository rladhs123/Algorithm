package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * K 번째 수
 *
 * 수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때,
 * 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
 */
public class Q11004 {

    static int N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        System.out.println(array[K - 1]);
    }
}
