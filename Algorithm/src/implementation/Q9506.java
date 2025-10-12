package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 약수들의 합
 *
 * 어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.
 * 예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.
 * n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.
 */
public class Q9506 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = sc.nextInt();

            if (n == -1) {
                break;
            }

            List<Integer> list = new ArrayList<>();
            int sum = 0;

            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    list.add(i);
                    sum += i;
                }
            }

            if (sum == n) {
                sb.append(n).append(" = ");

                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) {
                        sb.append(list.get(i));
                    } else {
                        sb.append(list.get(i)).append(" + ");
                    }
                }
            } else {
                sb.append(n).append(" is NOT perfect.");
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
