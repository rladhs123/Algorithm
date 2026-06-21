package programmers;

public class Q20260621 {

    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] arr = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            boolean check = false;

            for (char e : arr) {
                if (c == e) {
                    check = true;
                    break;
                }
            }

            if (!check) {
                sb.append(c);
            }
        }

        answer = sb.toString();

        return answer;
    }
}
