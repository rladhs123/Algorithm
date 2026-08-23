package leet;

public class Q20260823 {

    public int digitFrequencyScore(int n) {
        int[] freq = new int[10];
        String s = Integer.toString(n);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - '0']++;
        }

        int result = 0;

        for (int i = 1; i < freq.length; i++) {
            result += i * freq[i];
        }

        return result;
    }
}
