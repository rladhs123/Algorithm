package leet;

public class Q20260918 {

    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }

        boolean result = false;
        int sum = 1;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == num / i) {
                    sum += i;
                } else {
                    sum += i + (num / i);
                }
            }
        }

        if (sum == num) {
            result = true;
        }

        return result;
    }
}
