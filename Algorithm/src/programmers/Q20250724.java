package programmers;

public class Q20250724 {

    static int solution(int n) {
        int answer = 1;
        int x = 1;

        while (x != n) {
            int sum = 0;
            for (int i = x; i < n; i++) {
                if (sum > n) {
                    break;
                } else if (sum == n) {
                    break;
                } else {
                    sum += i;
                }
            }

            if (sum == n) {
                answer++;
            }
            x++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int result = solution(15);
        System.out.println(result);
    }
}
