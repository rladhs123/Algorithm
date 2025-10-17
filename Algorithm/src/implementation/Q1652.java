package implementation;

import java.util.Scanner;

/**
 * 누울 자리를 찾아라
 *
 * 일 년 동안 세계일주를 하던 영식이는 여행을 하다 너무 피곤해서 근처에 있는 코레스코 콘도에서 하룻밤 잠을 자기로 하고 방을 잡았다.
 *
 * 코레스코 콘도에 있는 방은 NxN의 정사각형모양으로 생겼다. 방 안에는 옮길 수 없는 짐들이 이것저것 많이 있어서 영식이의 누울 자리를 차지하고 있었다.
 * 영식이는 이 열악한 환경에서 누울 수 있는 자리를 찾아야 한다. 영식이가 누울 수 있는 자리에는 조건이 있다.
 * 똑바로 연속해서 2칸 이상의 빈 칸이 존재하면 그 곳에 몸을 양 옆으로 쭉 뻗으면서 누울 수 있다. 가로로 누울 수도 있고 세로로 누울 수도 있다.
 * 누울 때는 무조건 몸을 쭉 뻗기 때문에 반드시 벽이나 짐에 닿게 된다. (중간에 어정쩡하게 눕는 경우가 없다.)
 */
public class Q1652 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] room = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j++) {
                room[i][j] = input.charAt(j);
            }
        }

        int row = 0;
        int column = 0;

        for (int i = 0; i < n; i++) {
            int rowCount = 0;
            int columnCount = 0;

            for (int j = 0; j < n; j++) {
                if (room[i][j] == '.') {
                    rowCount++;
                } else {
                    if (rowCount >= 2) {
                        row++;
                    }
                    rowCount = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                if (room[j][i] == '.') {
                    columnCount++;
                } else {
                    if (columnCount >= 2) {
                        column++;
                    }
                    columnCount = 0;
                }
            }

            if (rowCount >= 2) {
                row++;
            }

            if (columnCount >= 2) {
                column++;
            }
        }

        System.out.println(row + " " + column);
    }
}
