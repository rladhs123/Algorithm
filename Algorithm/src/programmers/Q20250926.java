package programmers;

public class Q20250926 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int totalTile = brown + yellow;

        for (int i = 1; i <= totalTile / 2; i++) {
            if (totalTile % i == 0) {
                int length = totalTile / i;

                if ((i - 2) * (length - 2) == yellow) {
                    answer[0] = Math.max(i, length);
                    answer[1] = Math.min(i, length);
                    break;
                }
            }
        }
        return answer;
    }
}
