package leet;

import java.util.ArrayList;
import java.util.List;

public class Q20261013 {

    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                list.add(i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            int min = Integer.MAX_VALUE;

            for (int j : list) {
                int curr = Math.abs(j - i);

                if (curr < min) {
                    min = curr;
                }
            }

            result[i] = min;
        }

        return result;
    }
}
