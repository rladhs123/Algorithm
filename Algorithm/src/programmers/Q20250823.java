package programmers;

public class Q20250823 {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int last = -1;

            for (int j = 0; j < i; j++) {
                if (curr == s.charAt(j)) {
                    last = j;
                }
            }

            if (last == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - last;
            }
        }

        return answer;
    }
}
