package programmers;

import java.util.Scanner;

public class Q20250712 {

    static double solution(int[] arr) {
        double answer = 0;

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }

        answer /= arr.length;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        double result = solution(arr);

        System.out.println(result);
    }
}
