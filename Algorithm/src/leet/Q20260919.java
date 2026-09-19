package leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q20260919 {

    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;

        for (int num : nums) {
            set.add(num);
        }

        int[] arr = new int[set.size()];
        int i = 0;

        for (int x : set) {
            arr[i] = x;
            i++;
        }

        Arrays.sort(arr);

        if (arr.length < 3) {
            result = arr[arr.length - 1];
        } else {
            result = arr[arr.length - 3];
        }

        return result;
    }
}
