package leet;

public class Q20261111 {

    public int numOfStrings(String[] patterns, String word) {
        int result = 0;

        for (String s : patterns) {
            if (word.contains(s)) {
                result++;
            }
        }

        return result;
    }
}
