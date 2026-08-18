package leet;

public class Q20260818 {

    public String truncateSentence(String s, int k) {
        String result = "";
        String[] words = s.split(" ");

        for (int i = 0; i < k - 1; i++) {
            result += words[i] + " ";
        }

        return result + words[k - 1];
    }
}
