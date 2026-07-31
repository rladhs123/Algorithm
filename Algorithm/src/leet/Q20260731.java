package leet;

import java.util.HashSet;
import java.util.Set;

public class Q20260731 {

    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            set.add(i);
        }

        int result = 0;
        int i = 1;

        while (true) {
            if (!set.contains(i)) {
                k--;
            }

            if (k == 0) {
                result = i;
                break;
            }

            i++;
        }

        return result;
    }
}
