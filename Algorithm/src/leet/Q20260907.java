package leet;

import java.util.ArrayList;
import java.util.List;

public class Q20260907 {

    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2 && !list.contains(num1)) {
                    list.add(num1);
                }
            }
        }

        int size = list.size();
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
