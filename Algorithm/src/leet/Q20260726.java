package leet;

public class Q20260726 {

    public int islandPerimeter(int[][] grid) {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nY = i + dy[k];
                        int nX = j + dx[k];

                        if (nY < 0 || nX < 0 || nY >= grid.length || nX >= grid[i].length) {
                            result++;
                            continue;
                        }

                        if (grid[nY][nX] == 0) {
                            result++;
                        }
                    }
                }
            }
        }

        return result;
    }
}
