package leet;

public class Q20261026 {

    public int[][] largestLocal(int[][] grid) {
        int[][] result = new int[grid.length - 2][grid.length - 2];
        int x = 0;
        int y = 0;

        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                int m1 = Math.max(grid[i - 1][j - 1], Math.max(grid[i - 1][j], grid[i - 1][j + 1]));
                int m2 = Math.max(grid[i][j - 1], Math.max(grid[i][j], grid[i][j + 1]));
                int m3 = Math.max(grid[i + 1][j - 1], Math.max(grid[i + 1][j], grid[i + 1][j + 1]));

                result[y][x] = Math.max(m1, Math.max(m2, m3));
                x++;
            }

            x = 0;
            y++;
        }

        return result;
    }
}
