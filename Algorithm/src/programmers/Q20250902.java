package programmers;

public class Q20250902 {

    public boolean solution(String s) {
        boolean answer = false;

        if (s.length() == 4 || s.length() == 6) {
            boolean check = true;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) > '9') {
                    check = false;
                    System.out.println(s.charAt(i));
                    break;
                }
            }

            if (check) {
                answer = true;
            }
        }

        return answer;
    }
}
