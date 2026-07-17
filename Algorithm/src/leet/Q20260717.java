package leet;

public class Q20260717 {

    public int differenceOfSums(int n, int m) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                result -= i;
            } else {
                result += i;
            }
        }

        return result;
    }
}
