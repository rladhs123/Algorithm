package programmers;

public class Q20250818 {

    public long solution(int price, int money, int count) {
        long answer = -1;
        answer = (long) price * (count * (count + 1)) / 2 - money;

        if (answer < 0) {
            answer = 0;
        }

        return answer;
    }
}
