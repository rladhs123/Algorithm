package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 토마토
 *
 * 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
 * 토마토는 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.
 * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
 * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
 * 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 */
public class Q7569 {

    static int M, N, H;
    static int[][][] map;
    static boolean[][][] isVisited;
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static class Node {
        int z, y, x;

        public Node(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        map = new int[H][N][M];
        isVisited = new boolean[H][N][M];
        Queue<Node> queue = new LinkedList<>();

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[k][i][j] = sc.nextInt();
                    if (map[k][i][j] == 1) {
                        queue.offer(new Node(k, i, j));
                        isVisited[k][i][j] = true;
                    }
                }
            }
        }

        bfs(queue);

        int max = -123456789;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    if (map[k][i][j] > max) {
                        max = map[k][i][j];
                    }
                }
            }
        }

        if (max == 1) {
            System.out.println(0);
        } else {
            System.out.println(max - 1);
        }
    }

    static void bfs(Queue<Node> queue) {

        while (!queue.isEmpty()) {
            Node cullNode = queue.poll();

            for (int i = 0; i < dy.length; i++) {
                int nextZ = cullNode.z + dz[i];
                int nextY = cullNode.y + dy[i];
                int nextX = cullNode.x + dx[i];

                if (nextZ >= 0 && nextY >= 0 && nextX >= 0 && nextZ < H && nextY < N && nextX < M) {
                    if (!isVisited[nextZ][nextY][nextX] && map[nextZ][nextY][nextX] == 0) {
                        queue.offer(new Node(nextZ, nextY, nextX));
                        isVisited[nextZ][nextY][nextX] = true;
                        map[nextZ][nextY][nextX] = map[cullNode.z][cullNode.y][cullNode.x] + 1;
                    }
                }
            }
        }
    }
}
