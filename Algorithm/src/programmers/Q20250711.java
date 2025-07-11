package programmers;

import java.util.Scanner;

public class Q20250711 {
    static String solution(int num) {
        String answer = "";

        if (num % 2 == 0) {
            answer = "Even";
        } else {
            answer = "Odd";
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = solution(sc.nextInt());

        System.out.println(result);
    }
}
