package datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * AC
 *
 * 선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다.
 * AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.
 * 함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다.
 * 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.
 * 함수는 조합해서 한 번에 사용할 수 있다.
 * 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.
 * 배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.
 */
public class Q5430 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            String function = sc.next();
            sc.nextInt();
            String input = sc.next();
            Deque<Integer> deque = new ArrayDeque<>();
            String substring = input.substring(1, input.length() - 1);

            if (substring.equals("[]")) {
                System.out.println("error");
                continue;
            } else if(substring.equals("")) {
                if (function.contains("D")) {
                    System.out.println("error");
                } else {
                    System.out.println("[]");
                }
                continue;
            }
            String[] array = substring.split(",");

            for (String string : array) {
                deque.add(Integer.parseInt(string));
            }

            boolean isError = false;
            boolean topDown = false;
            for (int j = 0; j < function.length(); j++) {
                if (function.charAt(j) == 'R') {
                    topDown = !topDown;
                }

                if (function.charAt(j) == 'D') {
                    if (deque.isEmpty()) {
                        sb.append("error");
                        isError = true;
                        break;
                    } else {
                        if (topDown) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                    }
                }
            }

            if (!isError) {
                sb.append('[');
                while (!deque.isEmpty()) {
                    if (topDown) {
                        sb.append(deque.pollLast());
                    } else {
                        sb.append(deque.pollFirst());
                    }
                    if (!deque.isEmpty()) {
                        sb.append(',');
                    }
                }
                sb.append(']');
            }

            System.out.println(sb);
        }
    }
}
