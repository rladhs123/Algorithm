package leet;

public class Q20261028 {

    public int findPermutationDifference(String s, String t) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            for (int j = 0; j < t.length(); j++) {
                if (i != j && c == t.charAt(j)) {
                    result += Math.abs(i - j);
                }
            }
        }

        return result;
    }
}
