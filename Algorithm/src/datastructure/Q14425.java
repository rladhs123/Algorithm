package datastructure;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 문자열 집합
 *
 * 총 N개의 문자열로 이루어진 집합 S가 주어진다.
 * 입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.
 */
public class Q14425 {

    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            String input = sc.next();
            if (set.contains(input)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
