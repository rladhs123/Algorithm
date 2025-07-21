package programmers;

import java.util.Arrays;

public class Q20250721 {

    static int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - i - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {3, 4};
        int result = solution(A, B);

        System.out.println(result);
    }
}
