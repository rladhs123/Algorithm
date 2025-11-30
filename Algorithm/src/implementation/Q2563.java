package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2563 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[101][101];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (!map[y + j][x + k]) {
                        sum += 1;
                        map[y + j][x + k] = true;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
