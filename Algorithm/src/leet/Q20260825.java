package leet;

public class Q20260825 {

    public int mirrorDistance(int n) {
        String reverse = new StringBuilder(Integer.toString(n)).reverse().toString();

        return Math.abs(n - (Integer.parseInt(reverse)));
    }
}
