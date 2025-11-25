package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1996 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dx = {-1, 0, 1, 1, -1, 1, 0, -1};
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '.') {
                    for (int k = 0; k < 8; k++) {
                        int y = i + dy[k];
                        int x = j + dx[k];

                        if (y < 0 || x < 0 || y >= n || x >= n) {
                            continue;
                        }

                        if (arr[y][x] != '.') {
                            result[i][j] += arr[y][x] - '0';
                        }
                    }
                } else {
                    result[i][j] = -1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == -1) {
                    sb.append('*');
                } else if (result[i][j] >= 10){
                    sb.append('M');
                } else {
                    sb.append(result[i][j]);
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
