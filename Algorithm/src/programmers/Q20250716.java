package programmers;

import java.util.Scanner;

public class Q20250716 {

    static boolean solution(String s) {
        boolean answer = true;

        int q = 0;
        int y = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'p' || c == 'P') {
                q++;
            } else if (c == 'y' || c == 'Y') {
                y++;
            }
        }

        if (q != y) {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(solution(s));
    }
}
