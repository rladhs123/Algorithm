package leet;

import java.util.ArrayList;
import java.util.List;

public class Q20260820 {

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        int[] result = new int[nums.length];
        int x = 0;

        for (int i : list) {
            result[x] = i;
            x++;
        }

        return result;
    }
}
