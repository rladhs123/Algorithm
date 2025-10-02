package graph.dfs;

import java.util.Scanner;

/**
 * 양치기 꿍
 *
 * 양치기 꿍은 맨날 늑대가 나타났다고 마을 사람들을 속였지만 이젠 더이상 마을 사람들이 속지 않는다.
 * 화가 난 꿍은 복수심에 불타 아예 늑대들을 양들이 있는 울타리안에 마구 집어넣어 양들을 잡아먹게 했다.
 * 하지만 양들은 보통 양들이 아니다. 같은 울타리 영역 안의 양들의 숫자가 늑대의 숫자보다 더 많을 경우 늑대가 전부 잡아먹힌다.
 * 물론 그 외의 경우는 양이 전부 잡아먹히겠지만 말이다.
 * 꿍은 워낙 똑똑했기 때문에 이들의 결과는 이미 알고있다.
 * 만약 빈 공간을 '.'(점)으로 나타내고 울타리를 '#', 늑대를 'v', 양을 'k'라고 나타낸다면
 * 여러분은 몇 마리의 양과 늑대가 살아남을지 계산할 수 있겠는가?
 * 단, 울타리로 막히지 않은 영역에는 양과 늑대가 없으며 양과 늑대는 대각선으로 이동할 수 없다.
 */
public class Q3187 {

    static int R, C;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        isVisited = new boolean[R][C];
        int sheep = 0, wolf = 0;

        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == '#') {
                    isVisited[i][j] = true;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!isVisited[i][j]) {
                    result = new int[2];
                    dfs(i, j);

                    if (result[0] > result[1]) {
                        sheep += result[0];
                    } else {
                        wolf += result[1];
                    }
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;

        if (map[y][x] == 'v') {
            result[1]++;
        } else if (map[y][x] == 'k') {
            result[0]++;
        }

        for (int i = 0; i < 4; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];

            if (nY >= 0 && nX >= 0 && nY < R && nX < C) {
                if (!isVisited[nY][nX]) {
                    dfs(nY, nX);
                }
            }
        }
    }
}
