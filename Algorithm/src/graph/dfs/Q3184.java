package graph.dfs;

import java.util.Scanner;

/**
 * 양
 * 미키의 뒷마당에는 특정 수의 양이 있다. 그가 푹 잠든 사이에 배고픈 늑대는 마당에 들어와 양을 공격했다.
 * 마당은 행과 열로 이루어진 직사각형 모양이다. 글자 '.' (점)은 빈 필드를 의미하며, 글자 '#'는 울타리를, 'o'는 양, 'v'는 늑대를 의미한다.
 * 한 칸에서 수평, 수직만으로 이동하며 울타리를 지나지 않고 다른 칸으로 이동할 수 있다면, 두 칸은 같은 영역 안에 속해 있다고 한다.
 * 마당에서 "탈출"할 수 있는 칸은 어떤 영역에도 속하지 않는다고 간주한다.
 * 다행히 우리의 양은 늑대에게 싸움을 걸 수 있고 영역 안의 양의 수가 늑대의 수보다 많다면 이기고, 늑대를 우리에서 쫓아낸다.
 * 그렇지 않다면 늑대가 그 지역 안의 모든 양을 먹는다.
 * 맨 처음 모든 양과 늑대는 마당 안 영역에 존재한다.
 * 아침이 도달했을 때 살아남은 양과 늑대의 수를 출력하는 프로그램을 작성하라.
 */
public class Q3184 {

    static int R, C;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int totalSheep, totalWolf, sectorSheep, sectorWolf;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'o') {
                    totalSheep++;
                } else if (map[i][j] == 'v') {
                    totalWolf++;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !isVisited[i][j]) {
                    dfs(i, j);
                    isVisited[i][j] = true;

                    if (sectorSheep > sectorWolf) {
                        totalWolf -= sectorWolf;
                    } else {
                        totalSheep -= sectorSheep;
                    }

                    sectorWolf = 0;
                    sectorSheep = 0;
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    static void dfs(int y, int x) {

        isVisited[y][x] = true;

        if (map[y][x] == 'v') {
            sectorWolf++;
        } else if (map[y][x] == 'o') {
            sectorSheep++;
        }

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY >= 0 && nextX >= 0 && nextY < R && nextX < C) {
                if (map[nextY][nextX] != '#' && !isVisited[nextY][nextX]) {
                    dfs(nextY, nextX);
                }
            }
        }
    }
}
