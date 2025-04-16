package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 감소하는 수
 *
 * 음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다.
 * 예를 들어, 321과 950은 감소하는 수지만, 322와 958은 아니다.
 * N번째 감소하는 수를 출력하는 프로그램을 작성하시오.
 * 0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 만약 N번째 감소하는 수가 없다면 -1을 출력한다.
 */
public class Q1038 {

    static int N;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        if (N <= 10) {
            System.out.println(N);
            return;
        } else if (N >= 1023) {
            System.out.println(-1);
            return;
        }

        //C(10,1), C(10,2), ... , C(10,10)
        for (int i = 0; i < 10; i++) {
            dfs(i, i);
        }

        Collections.sort(list);
        System.out.println(list.get(N));
    }

    static void dfs(long num, int lastNum) {
        list.add(num);

        if (lastNum == 0) {
            return;
        }

        for (int i = 0; i < lastNum; i++) {
            dfs((num * 10) + i, i);
        }
    }
}
