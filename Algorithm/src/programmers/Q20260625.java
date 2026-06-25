package programmers;

public class Q20260625 {

    public int solution(int slice, int n) {
        int answer = n % slice == 0 ? n / slice : (n / slice) + 1;
        return answer;
    }
}
