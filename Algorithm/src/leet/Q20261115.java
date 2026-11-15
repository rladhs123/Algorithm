package leet;

public class Q20261115 {

    public int[] separateDigits(int[] nums) {
        String s = "";

        for (int num : nums) {
            s += Integer.toString(num);
        }

        int[] result = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i) - '0';
        }

        return result;
    }
}
