package programmers;

import java.util.Scanner;

public class Q20250715 {

    static long solution(int a, int b) {
        long answer = 0;

        int start = Math.min(a, b);
        int end = Math.max(a, b);

        answer = (long) (end + start) * (end - start + 1) / 2;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long result = solution(a, b);

        System.out.println(result);
    }
}
