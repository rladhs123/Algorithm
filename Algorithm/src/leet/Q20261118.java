package leet;

public class Q20261118 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;

        for (int i = 0; i < points.length - 1; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int nX = points[i + 1][0];
            int nY = points[i + 1][1];

            if (nY - y == nX - x) {
                result += Math.abs(nX - x);
            } else {
                int c = Math.min(Math.abs(nX - x), Math.abs(nY - y));
                result += c + Math.max(Math.abs(nX - x), Math.abs(nY - y)) - c;
            }
        }

        return result;
    }
}
