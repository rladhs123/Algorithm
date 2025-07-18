package programmers;

import java.util.Scanner;

public class Q20250718 {

    static int solution(int[] absolutes, boolean[] signs) {
        int answer = 123456789;
        int sum = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                sum += absolutes[i];
            } else {
                sum -= absolutes[i];
            }
        }

        answer = sum;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] absolutes = new int[3];
        for (int i = 0; i < 3; i++) {
            absolutes[i] = sc.nextInt();
        }
        boolean[] signs = {true, false, false};

        int result = solution(absolutes, signs);
        System.out.println(result);
    }
}
