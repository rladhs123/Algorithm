package datastructure;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 수 찾기
 *
 * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때,
 * 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 */
public class Q1920 {

    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            set.add(input);
        }

        M = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int n = sc.nextInt();

            if (set.contains(n)) {
                sb.append(1 + "\n");
            } else {
                sb.append(0 + "\n");
            }
        }

        System.out.print(sb);
    }
}
