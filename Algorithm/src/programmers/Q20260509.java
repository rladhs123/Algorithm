package programmers;

public class Q20260509 {

    public int solution(int[] numbers) {
        int max = -987654321;

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] * numbers[j] > max) {
                    max = numbers[i] * numbers[j];
                }
            }
        }

        return max;
    }
}
