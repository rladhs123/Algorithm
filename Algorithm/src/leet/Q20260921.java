package leet;

public class Q20260921 {

    public int arrangeCoins(int n) {
        int coin = 1;
        int row = 1;

        while (n - coin > row) {
            row++;
            coin += row;
        }

        return row;
    }
}
