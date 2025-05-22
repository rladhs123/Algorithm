package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 보물섬
 *
 * 보물섬 지도를 발견한 후크 선장은 보물을 찾아나섰다. 보물섬 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다.
 * 각 칸은 육지(L)나 바다(W)로 표시되어 있다. 이 지도에서 이동은 상하좌우로 이웃한 육지로만 가능하며, 한 칸 이동하는데 한 시간이 걸린다.
 * 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다.
 * 육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다.
 * 보물 지도가 주어질 때, 보물이 묻혀 있는 두 곳 간의 최단 거리로 이동하는 시간을 구하는 프로그램을 작성하시오.
 */
public class Q2589 {

    static int R, C;
    static char[][] map;
    static int[][] result;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

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

        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    result = new int[R][C];
                    bfs(i, j);

                    for (int k = 0; k < R; k++) {
                        for (int l = 0; l < C; l++) {
                            if (result[k][l] > max) {
                                max = result[k][l];
                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

    static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[R][C];
        queue.offer(new Node(y, x));
        isVisited[y][x] = true;
        result[y][x] = 0;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = curr.y + dy[i];
                int nextX = curr.x + dx[i];

                if (nextY >= 0 && nextX >= 0 && nextY < R && nextX < C) {
                    if (!isVisited[nextY][nextX] && map[nextY][nextX] == 'L') {
                        isVisited[nextY][nextX] = true;
                        result[nextY][nextX] = result[curr.y][curr.x] + 1;
                        queue.offer(new Node(nextY, nextX));
                    }
                }
            }
        }
    }
}
