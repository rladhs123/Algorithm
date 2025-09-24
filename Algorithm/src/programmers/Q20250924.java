package programmers;

public class Q20250924 {

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int billMin = Math.min(bill[0], bill[1]);
        int billMax = Math.max(bill[0], bill[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);
        int walletMax = Math.max(wallet[0], wallet[1]);

        while (billMin > walletMin || billMax > walletMax) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;

            billMax = Math.max(bill[0], bill[1]);
            billMin = Math.min(bill[0], bill[1]);
        }

        return answer;
    }
}
