package leet;

import java.util.HashSet;
import java.util.Set;

public class Q20260917 {

    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();

        for (int type : candyType) {
            set.add(type);
        }

        int result = 0;

        if (candyType.length / 2 >= set.size()) {
            result = set.size();
        } else {
            result = candyType.length / 2;
        }

        return result;
    }
}
