package graph.dfs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 숫자판 점프
 *
 * 5×5 크기의 숫자판이 있다. 각각의 칸에는 숫자(digit, 0부터 9까지)가 적혀 있다.
 * 이 숫자판의 임의의 위치에서 시작해서, 인접해 있는 네 방향으로 다섯 번 이동하면서,
 * 각 칸에 적혀있는 숫자를 차례로 붙이면 6자리의 수가 된다.
 * 이동을 할 때에는 한 번 거쳤던 칸을 다시 거쳐도 되며, 0으로 시작하는 000123과 같은 수로 만들 수 있다.
 * 숫자판이 주어졌을 때, 만들 수 있는 서로 다른 여섯 자리의 수들의 개수를 구하는 프로그램을 작성하시오.
 */
public class Q2210 {

    static char[][] map = new char[5][5];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = s[j].charAt(0);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(0, i, j, new char[6]);
            }
        }

        System.out.println(set.size());
    }

    static void dfs(int depth, int y, int x, char[] chars) {
        chars[depth] = map[y][x];
        if (depth == 5) {
            set.add(new String(chars));
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];

            if (nY >= 0 && nX >= 0 && nY < 5 && nX < 5) {
                dfs(depth + 1, nY, nX, chars);
            }
        }
    }
}
