package leet;

import java.util.ArrayList;
import java.util.List;

public class Q20260630 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean[] check = new boolean[nums.length + 1];
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            check[nums[i]] = true;
        }

        for (int i = 1; i <= size; i++) {
            if (!check[i]) {
                list.add(i);
            }
        }

        return list;
    }
}
