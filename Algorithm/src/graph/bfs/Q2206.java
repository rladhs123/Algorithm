package graph.bfs;

import java.util.*;

/**
 * 벽 부수고 이동하기
 *
 * N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다.
 * 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다.
 * 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.
 * 만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.
 * 한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.
 * 맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.
 */
public class Q2206 {

    static int N, M;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node {
        int y, x, distance, broken;

        public Node(int y, int x, int distance, int broken) {
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.broken = broken;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(Character.toString(input.charAt(j)));
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][][] isVisited = new boolean[2][N][M];
        queue.offer(new Node(0, 0, 1, 0));
        isVisited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.y == N - 1 && curr.x == M - 1) {
                return curr.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = curr.y + dy[i];
                int nextX = curr.x + dx[i];

                if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                    if (!isVisited[curr.broken][nextY][nextX] && map[nextY][nextX] == 0) {
                        queue.offer(new Node(nextY, nextX, curr.distance + 1, curr.broken));
                        isVisited[curr.broken][nextY][nextX] = true;
                    }

                    if (!isVisited[1][nextY][nextX] && map[nextY][nextX] == 1 && curr.broken == 0) {
                        queue.offer(new Node(nextY, nextX, curr.distance + 1, 1));
                        isVisited[1][nextY][nextX] = true;
                    }
                }
            }
        }

        return -1;
    }
}
