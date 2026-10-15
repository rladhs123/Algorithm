package leet;

import java.util.HashSet;
import java.util.Set;

public class Q20261015 {

    public int numEquivDominoPairs(int[][] dominoes) {
        Set<Integer> set = new HashSet<>();
        int result = 0;

        for (int i = 0; i < dominoes.length - 1; i++) {
            if (set.contains(i)) {
                continue;
            }

            Set<Integer> currSet = new HashSet<>();
            boolean check = false;

            for (int j = i + 1; j < dominoes.length; j++) {
                if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) ||
                        dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0]) {
                    set.add(j);
                    currSet.add(j);
                    check = true;
                }
            }

            if (check) {
                set.add(i);
                currSet.add(i);
                int size = currSet.size();
                result += (size * (size - 1)) / 2;
                currSet.clear();
            }
        }

        return result;
    }
}
