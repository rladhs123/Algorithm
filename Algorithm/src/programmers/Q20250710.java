package programmers;

import java.util.Scanner;

public class Q20250710 {
    static int[] solution(long n) {
        int[] answer = {};
        answer = new int[Long.toString(n).length()];
        int index = 0;

        while (n > 0) {
            answer[index++] = (int) (n % 10);
            n /= 10;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] result = solution(sc.nextInt());

        for (int i : result) {
            System.out.println(i);
        }
    }
}
