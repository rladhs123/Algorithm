package programmers;

public class Q20250728 {

     static int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int result = solution(5000);
        System.out.println(result);
    }
}
