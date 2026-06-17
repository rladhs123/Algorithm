package programmers;

public class Q20260617 {

    public int solution(int n) {
        int answer = 2;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n == i * i) {
                answer = 1;
                break;
            }
        }

        return answer;
    }
}
