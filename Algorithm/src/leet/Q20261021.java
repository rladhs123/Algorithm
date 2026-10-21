package leet;

public class Q20261021 {

    public int gcdOfOddEvenSums(int n) {
        int sumOdd = (n * (1 + (2 * n - 1))) / 2;
        int sumEven = (n * (2 + (2 * n))) / 2;
        int result = 0;

        for (int i = 1; i <= Math.min(sumOdd, sumEven); i++) {
            if (sumOdd % i == 0 && sumEven % i == 0) {
                result = i;
            }
        }

        return result;
    }
}
