package leet;

public class Q20260910 {

    public boolean lemonadeChange(int[] bills) {
        boolean result = true;
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five >= 1) {
                    five--;
                    ten++;
                } else {
                    result = false;
                    break;
                }
            } else {
                if (ten >= 1) {
                    if (five >= 1) {
                        five--;
                        ten--;
                    } else {
                        result = false;
                        break;
                    }
                } else {
                    if (five >= 3) {
                        five -= 3;
                    } else {
                        result = false;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
