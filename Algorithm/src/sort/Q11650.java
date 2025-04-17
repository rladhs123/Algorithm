package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 좌표 정렬하기
 * <p>
 * 2차원 평면 위의 점 N개가 주어진다.
 * 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 */
public class Q11650 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] list = new int[N][2];

        for (int i = 0; i < N; i++) {
            list[i][0] = sc.nextInt();
            list[i][1] = sc.nextInt();
        }

        Arrays.sort(list, (l1, l2) -> {
            if (l1[0] == l2[0]) {
                return l1[1] - l2[1];
            } else {
                return l1[0] - l2[0];
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(list[i][0] + " " + list[i][1]).append('\n');
        }

        System.out.println(sb);
    }
}
