package programmers;

public class Q20260610 {

    public int[] solution(int n) {
        int size = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                size++;
            }
        }

        int[] answer = new int[size];
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer[index] = i;
                index++;
            }
        }

        return answer;
    }
}
