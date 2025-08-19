package programmers;

public class Q20250819 {

    public int solution(String t, String p) {
        int answer = 0;
        long x = Long.parseLong(p);

        for (int i = 0; i <= t.length() - p.length(); i++) {
            String s = t.substring(i, i + p.length());
            long n = Long.parseLong(s);

            if (n <= x) {
                answer++;
            }
        }

        return answer;
    }
}
