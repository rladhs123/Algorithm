package programmers;

public class Q20260529 {

    public double solution(int[] numbers) {
        double answer = 0;

        for (int i : numbers) {
            answer += i;
        }

        return answer / numbers.length;
    }
}
