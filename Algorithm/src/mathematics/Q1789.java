package mathematics;

import java.util.Scanner;

/**
 * 수들의 합
 *
 * 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
 */
public class Q1789 {

    static long S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLong();

        long n = 1;
        for (long i = 1; i < S; i++) {
            if (i * (i + 1) / 2 <= S && (i + 1) * (i + 2) / 2 > S) {
                n = i;
                break;
            }
        }

        System.out.println(n);
    }
}
