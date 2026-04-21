package programmers;

public class Q20260421 {
    
    public int solution(int chicken) {
        int answer = 0;

        while (chicken >= 10) {
            int service = chicken / 10;
            int remain = chicken % 10;

            answer += service;
            chicken = service + remain;
        }

        return answer;
    }
}
