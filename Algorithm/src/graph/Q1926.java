package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 그림
 *
 * 어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라.
 * 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자.
 * 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다.
 * 그림의 넓이란 그림에 포함된 1의 개수이다.
 */
public class Q1926 {

    static int n, m;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && map[i][j] == 1) {
                    count++;
                    isVisited[i][j] = true;
                    dfs(i, j);
                    list.add(count);
                    count = 0;
                }
            }
        }
        if (list.isEmpty()) {
            System.out.println(0);
            System.out.println(0);
        } else {
            Object[] array = list.toArray();
            Arrays.sort(array);
            System.out.println(list.size());
            System.out.println(array[array.length - 1]);
        }

    }

    static void dfs(int y, int x) {

        for (int i = 0; i < dy.length; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY >= 0 && nextX >= 0 && nextY < n && nextX < m) {
                if (!isVisited[nextY][nextX] && map[nextY][nextX] == 1) {
                    count++;
                    isVisited[nextY][nextX] = true;
                    dfs(nextY, nextX);
                }
            }
        }
    }
}
