package programmers;

public class Q20260425 {

    public int solution(int i, int j, int k) {
        int answer = 0;

        for (int index = i; index <= j; index++) {
            String s = Integer.toString(index);

            for (int x = 0; x < s.length(); x++) {
                if (s.charAt(x) - '0' == k) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
