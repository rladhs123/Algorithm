package programmers;

public class Q20250812 {

    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            answer += (n / a) * b;
            n = (n / a) * b + (n % a);
        }

        /*
        answer = (n - a) / (a - b) * b + b;

        결국 교환이 얼마나 일어났는 지 계산해서 그 횟수에 b를 곱해주면 순수하게 받은 병의 갯수를 구할 수 있음

        a - b : 병 a개를 교환해서 b개를 얻기 때문에 이 수식은 순수하게 감소하는 병의 갯수를 의미
        ex) a = 2, b = 1 : 병 2개로 1개를 얻기 때문에 순수 감소는 1

        n - a : 마지막에 교환하는 a개의 병을 제외하는 수식

        (n - a) / (a - b) * b : 마지막 교환을 제외한 병 갯수에서 순수하게 일어난 교환 수 * b로 마지막 교환 전까지 얻은 병의 갯수
        + b : 마지막 교환으로 받은 b개의 병
         */

        return answer;
    }
}
