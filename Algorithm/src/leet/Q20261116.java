package leet;

public class Q20261116 {

    public int numberOfSteps(int num) {
        int result = 0;

        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }

            result++;
        }

        return result;
    }
}
