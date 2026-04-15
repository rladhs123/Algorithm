package programmers;


public class Q20260415 {

    public int solution(String s) {
        int answer = 0;

        char x = s.charAt(0);
        int countX = 1;
        int countY = 0;
        boolean check = false;

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (check) {
                x = curr;
            }

            if (x == curr) {
                countX++;
            } else {
                countY++;
            }

            if (countX == countY) {
                check = true;
                countX = 0;
                countY = 0;
                answer++;
            } else {
                check = false;
            }
        }

        return check ? answer : answer + 1;
    }
}
