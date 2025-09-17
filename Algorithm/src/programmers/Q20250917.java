package programmers;

public class Q20250917 {

    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] array = new int[number];

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    array[i - 1]++;

                    if (j != i / j) {
                        array[i - 1]++;
                    }
                }
            }
        }

        for (int i : array) {
            if (i > limit) {
                i = power;
            }

            answer += i;
        }

        return answer;
    }
}
