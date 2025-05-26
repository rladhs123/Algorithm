package graph.bfs;

import java.util.*;

/**
 * 아기 상어 2
 *
 * N×M 크기의 공간에 아기 상어 여러 마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 아기 상어가 최대 1마리 존재한다.
 * 어떤 칸의 안전 거리는 그 칸과 가장 거리가 가까운 아기 상어와의 거리이다.
 * 두 칸의 거리는 하나의 칸에서 다른 칸으로 가기 위해서 지나야 하는 칸의 수이고, 이동은 인접한 8방향(대각선 포함)이 가능하다.
 * 안전 거리가 가장 큰 칸을 구해보자.
 */
public class Q17086 {

    static int N, M;
    static int[][] map;
    static int[][] result;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        result = new int[N][M];
        List<Node> sharkList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 1) {
                    sharkList.add(new Node(i, j));
                }
            }
        }

        for (Node node : sharkList) {
            bfs(node.y, node.x);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (result[i][j] > max) {
                    max = result[i][j];
                }
            }
        }

        System.out.println(max);
    }

    static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][M];
        queue.offer(new Node(y, x));
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nextY = curr.y + dy[i];
                int nextX = curr.x + dx[i];

                if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                    if (!isVisited[nextY][nextX] && map[nextY][nextX] != 1) {
                        if (result[nextY][nextX] >= result[curr.y][curr.x] + 1 || result[nextY][nextX] == 0) {
                            result[nextY][nextX] = result[curr.y][curr.x] + 1;
                            queue.offer(new Node(nextY, nextX));
                            isVisited[nextY][nextX] = true;
                        }
                    }
                }
            }
        }
    }
}
