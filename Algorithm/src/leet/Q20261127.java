package leet;

public class Q20261127 {

    public int countAsterisks(String s) {
        String[] arr = s.split("\\|");
        int result = 0;

        for (int i = 0; i < arr.length; i+=2) {
            String curr = arr[i];

            for (int j = 0; j < curr.length(); j++) {
                char c = curr.charAt(j);

                if (c == '*') {
                    result++;
                }
            }
        }

        return result;
    }
}
