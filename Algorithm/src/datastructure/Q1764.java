package datastructure;

import java.util.*;

/**
 * 듣보잡
 *
 * 김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때,
 * 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
 */
public class Q1764 {

    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Set<String> list = new HashSet<>();
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            list.add(sc.next());
        }

        for (int i = 0; i < M; i++) {
            String input = sc.next();

            if (list.contains(input)) {
                result.add(input);
            }
        }

        Collections.sort(result);

        sb.append(result.size()).append('\n');
        for (String string : result) {
            sb.append(string).append('\n');
        }

        System.out.println(sb);
    }
}
