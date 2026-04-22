package programmers;

public class Q20260422 {

    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];

        for (String s : keyinput) {
            int moveX = 0;
            int moveY = 0;

            if (s.equals("left")) {
                moveX = -1;
            } else if (s.equals("right")) {
                moveX = 1;
            } else if (s.equals("up")) {
                moveY = 1;
            } else {
                moveY = -1;
            }

            if (moveX == 0) {
                if (Math.abs(answer[1] + moveY) <= board[1] / 2) {
                    answer[1] += moveY;
                }
            } else {
                if (Math.abs(answer[0] + moveX) <= board[0] / 2) {
                    answer[0] += moveX;
                }
            }
        }

        return answer;
    }
}
