package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 단어 정렬
 *
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 * 1. 길이가 짧은 것부터
 * 2. 길이가 같으면 사전 순으로
 * 단, 중복된 단어는 하나만 남기고 제거해야 한다.
 */
public class Q1181 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String input = sc.next();

            if (!list.contains(input)) {
                list.add(input);
            }
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length(); // 길이순 정렬
            }
            return o1.compareTo(o2); // 사전순 정렬
        });

        for (String word : list) {
            sb.append(word).append('\n');
        }
        System.out.println(sb);
    }
}
