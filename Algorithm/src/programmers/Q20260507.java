package programmers;

public class Q20260507 {

    public int solution(int num, int k) {
        int answer = -1;
        String s = Integer.toString(num);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c - '0' == k) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }
}
