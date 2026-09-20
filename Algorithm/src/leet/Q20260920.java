package leet;

public class Q20260920 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        int x = 0;

        for (int i = 0; i < t.length(); i++) {
            if (x >= s.length()) {
                break;
            }

            if (s.charAt(x) == t.charAt(i)) {
                x++;
            }
        }

        boolean result = false;

        if (x == s.length()) {
            result = true;
        }

        return result;
    }
}
