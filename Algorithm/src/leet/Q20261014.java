package leet;

public class Q20261014 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int result = 0;
        int empty = 0;

        while (numBottles > 0) {
            result += numBottles;
            empty += numBottles;
            numBottles = empty / numExchange;
            empty %= numExchange;
        }

        return result;
    }
}
