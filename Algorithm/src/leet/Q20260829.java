package leet;

public class Q20260829 {

    public String reversePrefix(String s, int k) {
        String result = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ((i + 1) <= k) {
                sb.append(c);
            } else {
                result += Character.toString(c);
            }
        }

        return sb.reverse().toString() + result;
    }
}
