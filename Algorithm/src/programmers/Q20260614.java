package programmers;

public class Q20260614 {

    public int solution(int[] sides) {
        int answer = 0;
        int max = Math.max(sides[0], Math.max(sides[1], sides[2]));
        int maxIndex = -1;
        int others = 0;

        for (int i = 0; i < 3; i++) {
            if (sides[i] == max) {
                maxIndex = i;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (i != maxIndex) {
                others += sides[i];
            }
        }

        if (max < others) {
            answer = 1;
        } else {
            answer = 2;
        }

        return answer;
    }
}
