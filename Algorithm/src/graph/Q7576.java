package graph;

import java.util.*;

/**
 * 토마토
 *
 * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
 * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
 * 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 */
public class Q7576 {

    static int M; //가로 칸
    static int N; //세로 칸
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int count;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[N][M];
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 1) {
                    list.add(new Node(i, j));
                }
            }
        }

        bfs(list);
        int max = Integer.MIN_VALUE;
        boolean isPerfect = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > max) {
                    max = map[i][j];
                }
                if (map[i][j] == 0) {
                    isPerfect = false;
                }
            }
        }

        if (isPerfect) {
            System.out.println(max - 1);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs(List<Node> list) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][M];

        for (Node node : list) {
            queue.offer(node);
            isVisited[node.y][node.x] = true;
        }

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currNode.y + dy[i];
                int nextX = currNode.x + dx[i];

                if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                    if (map[nextY][nextX] == 0 && !isVisited[nextY][nextX]) {
                        queue.offer(new Node(nextY, nextX));
                        isVisited[nextY][nextX] = true;
                        map[nextY][nextX] = map[currNode.y][currNode.x] + 1;
                    }
                }
            }
        }
    }
}
