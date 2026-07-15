package leet;

import java.util.HashSet;
import java.util.Set;

public class Q20260715 {

    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> set = new HashSet<>();
        int n = friends.length;

        for (int friend : friends) {
            set.add(friend);
        }

        int[] result = new int[n];
        int index = 0;

        for (int i : order) {
            if (set.contains(i)) {
                result[index] = i;
                set.remove(i);
                index++;
            }
        }

        return result;
    }
}
