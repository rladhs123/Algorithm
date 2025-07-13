package programmers;

import java.util.Scanner;

public class Q20250713 {

    static long[] solution(int x, int n) {
        long[] answer = {};
        answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = x + (long) x * i;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        long[] result = solution(x, n);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
