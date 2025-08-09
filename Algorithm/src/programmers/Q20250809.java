package programmers;

import java.util.Arrays;

public class Q20250809 {

    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int length = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                length++;
            } else {
                arr[i] = 0;
            }
        }

        if (length == 0) {
            answer = new int[] {-1};
        } else {
            int x = 0;
            answer = new int[length];

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    answer[x] = arr[i];
                    x++;
                }
            }
        }

        return answer;
    }
}
