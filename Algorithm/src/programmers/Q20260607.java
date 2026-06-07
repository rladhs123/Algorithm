package programmers;

public class Q20260607 {

    public int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            answer += c - '0';
        }

        return answer;
    }
}
