package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3085 {

    static int n;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int y = i + dy[k];
                    int x = j + dx[k];

                    if (y < 0 || x < 0 || y >= n || x >= n) {
                        continue;
                    }

                    char c = arr[i][j];
                    arr[i][j] = arr[y][x];
                    arr[y][x] = c;

                    int value = Math.max(max, Math.max(Math.max(countY(i), countY(y)), Math.max(countX(j), countX(x))));

                    if (value > max) {
                        max = value;
                    }

                    c = arr[i][j];
                    arr[i][j] = arr[y][x];
                    arr[y][x] = c;
                }
            }
        }

        System.out.println(max);
    }

    static int countY(int y) {
        int count = 1;
        char prev = arr[y][0];
        int max = 1;

        for (int i = 1; i < n; i++) {
            if (arr[y][i] == prev) {
                count++;
            } else {
                count = 1;
                prev = arr[y][i];
            }

            if (count > max) {
                max = count;
            }
        }

        return max;
    }

    static int countX(int x) {
        int count = 1;
        char prev = arr[0][x];
        int max = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i][x] == prev) {
                count++;
            } else {
                count = 1;
                prev = arr[i][x];
            }

            if (count > max) {
                max = count;
            }
        }

        return max;
    }
}
