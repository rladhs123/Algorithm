package graph.dfs;

import java.util.Scanner;

/**
 * 안전 영역
 *
 * 재난방재청에서는 많은 비가 내리는 장마철에 대비해서 다음과 같은 일을 계획하고 있다.
 * 먼저 어떤 지역의 높이 정보를 파악한다.
 * 그 다음에 그 지역에 많은 비가 내렸을 때 물에 잠기지 않는 안전한 영역이 최대로 몇 개가 만들어 지는 지를 조사하려고 한다.
 * 이때, 문제를 간단하게 하기 위하여, 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정한다.
 */
public class Q2468 {

    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        isVisited = new boolean[N][N];
        int maxHeight = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
            }
        }
        int maxSafeArea = -1;
        for (int k = 0; k < maxHeight; k++) {
            int safeArea = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j] && map[i][j] > k) {
                        dfs(i, j, k);
                        safeArea++;
                    }
                }
            }
            if (safeArea > maxSafeArea) {
                maxSafeArea = safeArea;
            }
            isVisited = new boolean[N][N];
        }

        System.out.println(maxSafeArea);
    }

    static void dfs(int y, int x, int height) {
        isVisited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < N && !isVisited[nextY][nextX]) {
                if (map[nextY][nextX] > height) {
                    dfs(nextY, nextX, height);
                }
            }
        }
    }
}
