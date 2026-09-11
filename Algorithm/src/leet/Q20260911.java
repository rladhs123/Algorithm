package leet;

public class Q20260911 {

    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int size = s.length();
        boolean result = true;

        for (int i = 0; i < size / 2; i++) {
            if (s.charAt(i) != s.charAt(size - i - 1)) {
                result = false;
                break;
            }
        }

        return result;
    }
}
