package sort;

import java.util.*;

/**
 * 중복 빼고 정렬하기
 *
 * N개의 정수가 주어진다. 이때, N개의 정수를 오름차순으로 정렬하는 프로그램을 작성하시오. 같은 정수는 한 번만 출력한다.
 */
public class Q10867 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (!list.contains(input)) {
                list.add(input);
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        for (Integer i : list) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }
}
