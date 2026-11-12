package leet;

public class Q20261112 {
    
    public int countDigits(int num) {
        String s = Integer.toString(num);
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (num % (c - '0') == 0) {
                result++;
            }
        }

        return result;
    }
}
