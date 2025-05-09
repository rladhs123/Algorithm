package graph.dfs;

import java.util.Scanner;

public class Q2573 {

    static int R, C;
    static int[][] map;
    static boolean[][] isVisited;
    static int year, section;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new int[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 0 && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    dfs(i, j);
                    section++;
                }
            }
        }

        if (section >= 2) {
            System.out.println(0);
            return;
        }

        while (section < 2) {
            isVisited = new boolean[R][C];
            section = 0;
            boolean isZero = false; //섹션이 2개 이상으로 나눠지지 않고 모든 빙하가 다 녹을 때
            //감소하는 빙하 계산
            int[][] minus = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] != 0) {
                        isZero = true;
                        minus[i][j] = decrease(i, j);
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j] -= minus[i][j];

                    if (map[i][j] < 0) {
                        map[i][j] = 0;
                    }
                }
            }

            if (!isZero) {
                System.out.println(0);
                return;
            }

            //섹션 계산
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] != 0 && !isVisited[i][j]) {
                        isVisited[i][j] = true;
                        dfs(i, j);
                        section++;
                    }
                }
            }

            year++;
        }

        System.out.println(year);
    }

    static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY >= 0 && nextX >= 0 && nextY < R && nextX < C) {
                if (map[nextY][nextX] != 0 && !isVisited[nextY][nextX]) {
                    isVisited[nextY][nextX] = true;
                    dfs(nextY, nextX);
                }
            }
        }
    }

    static int decrease(int y, int x) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY >= 0 && nextX >= 0 && nextY < R && nextX < C) {
                if (map[nextY][nextX] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
