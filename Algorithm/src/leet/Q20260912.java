package leet;

public class Q20260912 {

    public String longestCommonPrefix(String[] strs) {
        int min = 200;
        String str = "";

        for (String s : strs) {
            if (s.length() < min) {
                min = s.length();
                str = s;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < min; i++) {
            char c = str.charAt(i);
            boolean check = true;

            for (String s : strs) {
                if (c != s.charAt(i)) {
                    check = false;
                    break;
                }
            }

            if (!check) {
                break;
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
