package leet;

public class Q20261001 {

    public int countNegatives(int[][] grid) {
        int result = 0;
        int row = grid.length - 1;
        int col = 0;

        while (row >= 0 && col < grid[0].length) {
            if (grid[row][col] < 0) {
                result += grid[row].length - col;
                row--;
            } else {
                col++;
            }
        }

        return result;
    }
}
