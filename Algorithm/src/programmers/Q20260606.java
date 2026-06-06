package programmers;

public class Q20260606 {

    public int[] solution(int n) {
        int size = 0;

        if (n % 2 == 0) {
            size = n / 2;
        } else {
            size = (n / 2) + 1;
        }

        int[] answer = new int[size];
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                answer[index] = i;
                index++;
            }
        }

        return answer;
    }
}
