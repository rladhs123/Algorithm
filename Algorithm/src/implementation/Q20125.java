package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q20125 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] array = new char[n][n];
        boolean checkHeart = false;
        int heartY = -1;
        int heartX = -1;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                array[i][j] = s.charAt(j);

                if (i >= 1 && !checkHeart) {
                    if (array[i - 1][j] == '*' && array[i][j] == '*') {
                        checkHeart = true;
                        heartY = i;
                        heartX = j;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(heartY + 1).append(' ').append(heartX + 1).append('\n');

        //get arm
        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            if (array[heartY][i] == '*') {
                if (i < heartX) {
                    left++;
                } else if (i > heartX) {
                    right++;
                }
            }
        }

        sb.append(left).append(' ').append(right).append(' ');

        //get center
        int center = 0;

        for (int i = heartY + 1; i < n; i++) {
            if (array[i][heartX] == '*') {
                center++;
            }
        }

        sb.append(center).append(' ');

        //get leg
        left = 0;
        right = 0;

        for (int i = heartY + center + 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == '*') {
                    if (j < heartX) {
                        left++;
                    } else if (j > heartX) {
                        right++;
                    }
                }
            }
        }

        sb.append(left).append(' ').append(right);

        System.out.println(sb);
    }
}
