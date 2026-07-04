package leet;

public class Q20260704 {

    public int[] finalPrices(int[] prices) {
        int size = prices.length;
        int[] result = new int[size];

        for (int i = 0; i < size - 1; i++) {
            result[i] = prices[i];

            for (int j = i + 1; j < size; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        result[size - 1] = prices[size - 1];

        return result;
    }
}
