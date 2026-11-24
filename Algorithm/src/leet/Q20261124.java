package leet;

public class Q20261124 {

    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        StringBuilder sb;
        int result = Integer.parseInt(s);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c - '0' == 9) {
                continue;
            }

            sb = new StringBuilder();
            sb.append(s.substring(0, i)).append('9').append(s.substring(i + 1, s.length()));
            String curr = sb.toString();

            result = Math.max(Integer.parseInt(curr), result);
        }

        return result;
    }
}
