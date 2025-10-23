package graph.dfs;

import java.util.Scanner;

/**
 * 세 번 이내에 사과를 먹자
 *
 * 5 x 5 크기의 보드가 주어진다. 보드는 1 x 1 크기의 정사각형 격자로 이루어져 있다.
 * 보드의 격자는 사과가 1개 있는 격자, 장애물이 있는 격자, 빈칸으로 되어 있는 격자로 구분된다.
 * 격자의 위치는 (r, c)로 표시한다. r은 행 번호, c는 열 번호를 나타낸다. 행 번호는 맨 위 위치가 0이고 아래 방향으로 1씩 증가한다.
 * 열 번호는 맨 왼쪽 위치가 0이고 오른쪽으로 1씩 증가한다. 즉, 맨 왼쪽 위 위치가 (0, 0), 맨 아래 오른쪽 위치가 (4, 4)이다.
 * 현재 한 명의 학생이 (r, c) 위치에 있고 한 번의 이동으로 상, 하, 좌, 우 방향 중에서 한가지 방향으로 한 칸 이동할 수 있다.
 * 학생이 사과가 있는 칸으로 이동하면 해당 칸에 있는 사과를 1개 먹는다. 장애물이 있는 칸으로는 이동할 수 없다.
 * 학생이 지나간 칸은 학생이 해당 칸을 떠나는 즉시 장애물이 있는 칸으로 변경된다.
 * 즉, 학생이 해당 칸에서 상, 하, 좌, 우 방향으로 한 칸 이동하는 즉시 해당 칸은 장애물이 있는 칸으로 변경된다.
 * 학생이 현재 위치 (r, c)에서 세 번 이하의 이동으로 사과를 2개 이상 먹을 수 있으면 1을 출력하고, 그렇지 않으면 0을 출력하자.
 */
public class Q26169 {

    static int[][] map = new int[5][5];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean check = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt();
        int c = sc.nextInt();

        dfs(r, c, 0, 0);

        if (check) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void dfs(int y, int x, int depth, int count) {
        if (count >= 2) {
            check = true;
            return;
        }

        if (depth == 3) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];

            if (nY >= 0 && nX >= 0 && nY < 5 && nX < 5) {
                if (map[nY][nX] != -1) {
                    int temp = map[y][x];
                    map[y][x] = -1;
                    int add = 0;
                    if (map[nY][nX] == 1) {
                        add = 1;
                    }

                    dfs(nY, nX, depth + 1, count + add);
                    map[y][x] = temp;

                    if (check) {
                        return;
                    }
                }
            }
        }
    }
}
