package leet;

public class Q20261128 {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        String s = Integer.toString(x);
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }

        int result = -1;

        if (x % sum == 0) {
            result = sum;
        }

        return result;
    }
}
