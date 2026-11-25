package leet;

public class Q20261125 {

    public int pivotInteger(int n) {
        int sumOfAll = (n * (n + 1)) / 2;
        int sum = 0;
        int result = -1;

        for (int i = 1 ; i <= n; i++) {
            sum += i;

            if (sum == sumOfAll - sum + i) {
                result = i;
                break;
            }
        }

        return result;
    }
}
