package leet;

public class Q20260916 {

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            profit = Math.max(profit, price - minPrice);
        }

        return profit;
    }
}
