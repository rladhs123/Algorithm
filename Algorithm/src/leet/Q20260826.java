package leet;

public class Q20260826 {

    public int finalValueAfterOperations(String[] operations) {
        int result = 0;

        for (String operation : operations) {
            char c = operation.charAt(1);

            if (c == '+') {
                result++;
            } else {
                result--;
            }
        }

        return result;
    }
}
