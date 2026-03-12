package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1992 {

    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        quadTree(0, 0, N, N);

        System.out.println(sb);
    }

    static void quadTree(int startY, int startX, int endY, int endX) {
        if (startY - endY == 0 || startX - endX == 0) {
            return;
        }

        boolean check = false;

        for (int i = startY; i < endY; i++) {
            for (int j = startX; j < endX; j++) {
                if (map[startY][startX] != map[i][j]) {
                    check = true;
                    break;
                }
            }
        }

        if (check) {
            sb.append('(');
            quadTree(startY, startX, (startY + endY) / 2, (startX + endX) / 2);
            quadTree(startY, (startX + endX) / 2, (startY + endY) / 2, endX);
            quadTree((startY + endY) / 2, startX, endY, (startX + endX) / 2);
            quadTree((startY + endY) / 2, (startX + endX) / 2, endY, endX);
            sb.append(')');
        } else {
            sb.append(map[startY][startX]);
        }

    }
}
