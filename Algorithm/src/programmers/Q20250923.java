package programmers;

public class Q20250923 {

    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] check = new boolean[n];

        //전체에서 다시 칠해야 하는 구역을 true 설정
        for (int i = 0; i < section.length; i++) {
            check[section[i]] = true;
        }

        //전체를 돌다가 true 발견하면 그곳에서부터 m 칸까지 false 설정
        for (int i = 0; i <= n - m; i++) {
            if (check[i]) {
                for (int j = i; j < i + m; j++) {
                    check[j] = false;
                }
                answer++;
            }
        }

        /*
        더 좋은 방식
        
        int lastPainted = 0;

        for (int s : section) {
            if (s > lastPainted) {
                lastPainted = s + m - 1;
                answer++;
            }
        }
        */
        return answer;
    }
}
