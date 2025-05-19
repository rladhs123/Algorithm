package graph.dfs;

import java.util.Scanner;

/**
 * 전쟁 - 전투
 *
 * 전쟁은 어느덧 전면전이 시작되었다. 결국 전투는 난전이 되었고, 우리 병사와 적국 병사가 섞여 싸우게 되었다.
 * 그러나 당신의 병사들은 흰색 옷을 입고, 적국의 병사들은 파란색 옷을 입었기 때문에 서로가 적인지 아군인지는 구분할 수 있다.
 * 문제는 같은 팀의 병사들은 모이면 모일수록 강해진다는 사실이다.
 * N명이 뭉쳐있을 때는 N2의 위력을 낼 수 있다. 과연 지금 난전의 상황에서는 누가 승리할 것인가?
 * 단, 같은 팀의 병사들이 대각선으로만 인접한 경우는 뭉쳐 있다고 보지 않는다.
 */
public class Q1303 {

    static int R, C;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int blueTeam, whiteTeam, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        R = sc.nextInt();
        map = new char[R][C];
        isVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!isVisited[i][j]) {
                    dfs(i, j);

                    if (map[i][j] == 'W') {
                        whiteTeam += count * count;
                    } else {
                        blueTeam += count * count;
                    }

                    count = 0;
                }
            }
        }

        System.out.println(whiteTeam + " " + blueTeam);
    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY >= 0 && nextX >= 0 && nextY < R && nextX < C) {
                if (!isVisited[nextY][nextX] && map[nextY][nextX] == map[y][x]) {
                    dfs(nextY, nextX);
                }
            }
        }
    }
}
