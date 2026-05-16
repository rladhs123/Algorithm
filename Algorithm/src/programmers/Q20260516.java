package programmers;

public class Q20260516 {

    public String solution(String my_string, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);

            for (int j = 0; j < n; j++) {
                sb.append(c);
            }
        }

        answer = sb.toString();

        return answer;
    }
}
