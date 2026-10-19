package leet;

public class Q20261019 {

    public int reverseDegree(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result += ('z' - c + 1) * (i + 1);
        }

        return result;
    }
}
