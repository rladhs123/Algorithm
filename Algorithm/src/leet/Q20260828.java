package leet;

import java.util.ArrayList;
import java.util.List;

public class Q20260828 {

    public int[] getSneakyNumbers(int[] nums) {
        int[] check = new int[101];

        for (int num : nums) {
            check[num]++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < check.length; i++) {
            if (check[i] == 2) {
                list.add(i);
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
