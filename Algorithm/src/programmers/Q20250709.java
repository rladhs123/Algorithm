package programmers;

import java.util.Scanner;

public class Q20250709 {
    static int solution(int n) {
        int answer = 0;

        String s = Integer.toString(n);

        for (int i = 0; i < s.length(); i++) {
            answer += Integer.parseInt(Character.toString(s.charAt(i)));
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = solution(n);

        System.out.println(result);
    }
}
