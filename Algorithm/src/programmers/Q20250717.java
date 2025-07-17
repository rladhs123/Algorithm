package programmers;

import java.util.Scanner;

public class Q20250717 {

    static long solution(long n) {
        long answer = 0;
        long x = 1;

        while (true) {
            if (x * x == n) {
                answer = (x + 1) * (x + 1);
                break;
            } else if (x * x > n) {
                answer = -1;
                break;
            }

            x++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long result = solution(sc.nextLong());

        System.out.println(result);
    }
}
