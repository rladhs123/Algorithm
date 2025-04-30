package backtracking;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 암호 만들기
 *
 * 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며
 * 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다.
 * 또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아
 * 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다.
 * 즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.
 * 새 보안 시스템에서 조교들이 암호로 사용했을 법한 문자의 종류는 C가지가 있다고 한다.
 * 이 알파벳을 입수한 민식, 영식 형제는 조교들의 방에 침투하기 위해 암호를 추측해 보려고 한다.
 * C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.
 */
public class Q1759 {

    static int L, C;
    static char[] array;
    static char[] password;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        array = new char[C];
        password = new char[L];

        for (int i = 0; i < C; i++) {
            array[i] = sc.next().charAt(0);
        }

        Arrays.sort(array);

        backTracking(0, 0);

        System.out.print(sb);
    }

    //a, e, i, o, u 중 최소 하나 + 나머지 알파벳 중 최소 2개
    //일단 조합을 뽑고 그 패스워드가 조건에 맞는 지 체크
    //조건에 맞으면 출력, 아니면 넘김
    static void backTracking(int depth, int index) {
        if (depth == L) {
            if (isValid()) {
                for (char c : password) {
                    sb.append(c);
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = index; i < array.length; i++) {
            password[depth] = array[i];
            backTracking(depth + 1, i + 1);
        }
    }

    static boolean isValid() {
        int vowel = 0;
        int consonant = 0;

        for (char c : password) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }

        if (vowel >= 1 && consonant >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
