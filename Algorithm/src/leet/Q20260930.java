package leet;

import java.util.HashSet;
import java.util.Set;

public class Q20260930 {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        int[] arr = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            int sum = 0;

            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }

            arr[i] = sum;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < k; i++) {
            int min = mat[0].length + 1;
            int minIndex = -1;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < min && !set.contains(j)) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            result[i] = minIndex;
            set.add(minIndex);
        }

        return result;
    }
}
