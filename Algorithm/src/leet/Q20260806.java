package leet;

public class Q20260806 {

    public boolean detectCapitalUse(String word) {
        boolean result = false;
        char firstLetter = word.charAt(0);

        if (firstLetter > 'Z') {
            for (int i = 1; i < word.length(); i++) {
                char c = word.charAt(i);

                if (c <= 'Z') {
                    return result;
                }
            }

            result = true;
        } else {
            int count = 1;

            for (int i = 1; i < word.length(); i++) {
                char c = word.charAt(i);

                if (c <= 'Z') {
                    count++;
                }
            }

            if (count == word.length() || count == 1) {
                result = true;
            }

        }

        return result;
    }
}
