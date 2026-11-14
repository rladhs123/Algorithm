package leet;

public class Q20261114 {

    public int subtractProductAndSum(int n) {
        String s = Integer.toString(n);
        int a = 1;
        int b = 0;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            a *= c;
            b += c;
        }

        return a - b;
    }
}
