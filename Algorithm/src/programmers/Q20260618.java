package programmers;

public class Q20260618 {

    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);

            if (c >= 'a' && c <= 'z') {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }

            sb.append(c);
        }

        answer = sb.toString();

        return answer;
    }
}
