package leet;

import java.util.Arrays;

public class Q20261119 {

    public int maxWidthOfVerticalArea(int[][] points) {
        int[] arr = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            arr[i] = points[i][0];
        }

        Arrays.sort(arr);
        int gap = arr[1] - arr[0];

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] > gap) {
                gap = arr[i + 1] - arr[i];
            }
        }

        return gap;
    }
}
