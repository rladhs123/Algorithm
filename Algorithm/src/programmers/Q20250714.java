package programmers;

import java.util.Scanner;

public class Q20250714 {

    static int solution(int n) {
        int answer = 0;

        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = solution(sc.nextInt());

        System.out.println(result);
    }
}
