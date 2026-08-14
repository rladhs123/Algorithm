package leet;

public class Q20260814 {

    public int maximumWealth(int[][] accounts) {
        int max = -1;

        for (int[] account : accounts) {
            int sum = 0;

            for (int wealth : account) {
                sum += wealth;
            }

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }
}
