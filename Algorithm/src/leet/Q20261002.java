package leet;

import java.util.ArrayList;
import java.util.List;

public class Q20261002 {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            int minCol = 0;

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minCol = j;
                }
            }

            int max = 0;

            for (int j = 0; j < m; j++) {
                if (matrix[j][minCol] > max) {
                    max = matrix[j][minCol];
                }
            }

            if (min == max) {
                result.add(min);
            }
        }

        return result;
    }
}
