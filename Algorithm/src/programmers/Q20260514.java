package programmers;

public class Q20260514 {

    public String solution(String my_string, String letter) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);

            if (c == letter.charAt(0)) {
                continue;
            }

            sb.append(c);
        }

        answer = sb.toString();

        return answer;
    }
}
