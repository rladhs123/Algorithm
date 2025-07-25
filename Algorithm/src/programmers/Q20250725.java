package programmers;

public class Q20250725 {

    static int solution(int n) {
        int answer = 0;
        String binaryN = Integer.toBinaryString(n);
        int countN = 0;

        for (int i = 0; i < binaryN.length(); i++) {
            if (binaryN.charAt(i) == '1') {
                countN++;
            }
        }

        int m = n;

        while (true) {
            m++;
            String binaryM = Integer.toBinaryString(m);
            int countM = 0;

            for (int i = 0; i < binaryM.length(); i++) {
                if (binaryM.charAt(i) == '1') {
                    countM++;
                }
            }

            if (countN == countM) {
                answer = m;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int result = solution(15);
        System.out.println(result);
    }
}
