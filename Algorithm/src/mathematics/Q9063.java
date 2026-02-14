package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9063 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int[][] set = new int[n][2];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            set[i][0] = Integer.parseInt(st.nextToken());
            set[i][1] = Integer.parseInt(st.nextToken());
        }

        int minX = 10001; int maxX = -10001;
        int minY = 10001; int maxY = -10001;

        for (int i = 0; i < n; i++) {
            int currX = set[i][0];
            int currY = set[i][1];

            if (currX > maxX) {
                maxX = currX;
            }

            if (currX < minX) {
                minX = currX;
            }

            if (currY > maxY) {
                maxY = currY;
            }

            if (currY < minY) {
                minY = currY;
            }
        }

        System.out.println((maxX - minX) * (maxY - minY));
    }
}
