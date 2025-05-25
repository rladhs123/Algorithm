package implementation;

import java.util.Scanner;

/**
 * 로봇 청소기
 *
 * 로봇 청소기와 방의 상태가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.
 *
 * 정사각형 칸으로 나누어져 있다. 각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북 중 하나이다. 방의 각 칸은 좌표
 * 로봇 청소기는 다음과 같이 작동한다.
 *
 * 1 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
 * 2 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
 *      바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
 *      바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
 * 3 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
 *      반시계 방향으로 90도 회전한다.
 *      바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
 *      1번으로 돌아간다.
 */
public class Q14503 {

    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int COUNT;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int startY = sc.nextInt();
        int startX = sc.nextInt();
        int startDirection = sc.nextInt();
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    isVisited[i][j] = true;
                }
            }
        }

        dfs(startY, startX, startDirection);

        System.out.println(COUNT);
    }


    // d = 0 -> 북쪽, d = 1 -> 동쪽, d = 2 남쪽, d = 3 서쪽
    static void dfs(int y, int x, int d) {


        //현재 칸이 청소되지 않은 경우 -> 청소(count + 1)
        if (map[y][x] == 0 && !isVisited[y][x]) {
            COUNT++;
            isVisited[y][x] = true;
        }

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nextY = y + dy[d];
            int nextX = x + dx[d];

            if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                if (!isVisited[nextY][nextX] && map[nextY][nextX] == 0) {
                    dfs(nextY, nextX, d);
                    return;
                }
            }
        }

        int backD = (d + 2) % 4;
        int backY = y + dy[backD];
        int backX = x + dx[backD];

        if (backY >= 0 && backX >= 0 && backY < N && backX < M && map[backY][backX] == 0) {
            dfs(backY, backX, d);
        }

    }

}
