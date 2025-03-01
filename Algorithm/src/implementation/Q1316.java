package implementation;

import java.util.*;

/**
 * 그룹 단어 체커
 *
 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
 * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
 * aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 */
public class Q1316 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            boolean isGroup;
            isGroup = check(input);

            if (isGroup) {
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean check(String input) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (!list.contains(input.charAt(i))) {
                list.add(input.charAt(i));
            }
        }

        int count = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            char currChar = input.charAt(i);
            char nextChar = input.charAt(i + 1);

            if (currChar != nextChar) {
                count++;
            }
        }

        if (count == list.size() - 1) return true;
        else return false;
    }
}
