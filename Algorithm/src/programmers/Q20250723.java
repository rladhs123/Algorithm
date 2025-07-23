package programmers;

public class Q20250723 {

    static int[] solution(String s) {
        int[] answer = {};
        answer = new int[2];

        while (s.length() != 1) {
            StringBuilder sb = new StringBuilder();
            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }

            answer[0]++;
            answer[1] += s.length() - count;

            while (count > 0) {
                sb.insert(0, count % 2);
                count /= 2;
            }

            s = sb.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] result = solution("110010101001");

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
