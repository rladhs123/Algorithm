package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 쉬운 최단거리
 *
 * 지도가 주어지면 모든 지점에 대해서 목표지점까지의 거리를 구하여라.
 * 문제를 쉽게 만들기 위해 오직 가로와 세로로만 움직일 수 있다고 하자.
 */
public class Q14940 {

    static int n, m;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        isVisited = new boolean[n][m];
        int startY = 0;
        int startX = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    startY = i;
                    startX = j;
                }
            }
        }

        bfs(startY, startX);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isVisited[i][j] || map[i][j] == 0) {
                    sb.append(map[i][j]).append(' ');
                } else {
                    sb.append(-1).append(' ');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void bfs(int startY, int startX) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startY, startX));
        isVisited[startY][startX] = true;
        map[startY][startX] = 0;

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            for (int i = 0; i < dy.length; i++) {
                int nextY = currNode.y + dy[i];
                int nextX = currNode.x + dx[i];

                if (nextY >= 0 && nextX >= 0 && nextY < n && nextX < m) {
                    if (!isVisited[nextY][nextX] && map[nextY][nextX] == 1) {
                        queue.offer(new Node(nextY, nextX));
                        isVisited[nextY][nextX] = true;
                        map[nextY][nextX] = map[currNode.y][currNode.x] + 1;
                    }
                }
            }
        }
    }
}
