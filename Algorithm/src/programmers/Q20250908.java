package programmers;

public class Q20250908 {

    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                index = 0;
                sb.append(' ');
            } else {
                if (index % 2 == 0) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                index++;
            }
        }

        answer = sb.toString();
        return answer;
    }
}
