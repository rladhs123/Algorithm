package leet;

public class Q20261113 {

    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int index = -1;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == ch) {
                for (int j = i; j >= 0; j--) {
                    sb.append(word.charAt(j));
                }

                index = i;
                break;
            }
        }

        for (int i = index + 1; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }

        return sb.toString();
    }
}
