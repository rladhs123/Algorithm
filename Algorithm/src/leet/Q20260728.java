package leet;

public class Q20260728 {

    public int[][] transpose(int[][] matrix) {
        int y = matrix.length;
        int x = matrix[0].length;
        int[][] result = new int[x][y];

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}
