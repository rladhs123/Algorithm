package leet;

public class Q20261101 {

    public int maxFreqSum(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        int vowel = -1;
        int consonant = -1;

        for (int i = 0; i < arr.length; i++) {
            char c = (char) (i + 'a');

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                if (arr[i] > vowel) {
                    vowel = arr[i];
                }
            } else {
                if (arr[i] > consonant) {
                    consonant = arr[i];
                }
            }
        }

        return vowel + consonant;
    }
}
