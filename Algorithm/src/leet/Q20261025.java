package leet;

import java.util.ArrayList;
import java.util.List;

public class Q20261025 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }

        List<Boolean> list = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies < max) {
                list.add(false);
            } else {
                list.add(true);
            }
        }

        return list;
    }
}
