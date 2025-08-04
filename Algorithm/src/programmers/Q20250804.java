package programmers;

public class Q20250804 {

    public int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 0;
        int maxH = 0;

        for (int i = 0; i < sizes.length; i++) {
            int w, h;
            w = sizes[i][0];
            h = sizes[i][1];

            maxW = Math.max(maxW, Math.max(w, h));
            maxH = Math.max(maxH, Math.min(w, h));
        }

        answer = maxW * maxH;
        return answer;
    }
}
