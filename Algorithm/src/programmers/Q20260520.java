package programmers;

public class Q20260520 {

    public String solution(String cipher, int code) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cipher.length(); i++) {
            char c = cipher.charAt(i);

            if ((i + 1) % code == 0) {
                sb.append(c);
            }
        }

        answer = sb.toString();

        return answer;
    }
}
