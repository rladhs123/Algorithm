package leet;

public class Q20261110 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "";
        String s2 = "";

        for (String s : word1) {
            s1 += s;
        }

        for (String s : word2) {
            s2 += s;
        }

        boolean result = false;

        if (s1.equals(s2)) {
            result = true;
        }

        return result;
    }
}
