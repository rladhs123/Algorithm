package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q14497 {

    static int N, M, startY, startX, endY, endX;
    static char[][] map;
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
        N = sc.nextInt();
        M = sc.nextInt();
        startY = sc.nextInt() - 1;
        startX = sc.nextInt() - 1;
        endY = sc.nextInt() - 1;
        endX = sc.nextInt() - 1;
        map = new char[N][M];
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        int jumps = 0;
        Queue<Node> curr = new LinkedList<>();
        curr.offer(new Node(startY, startX));
        isVisited = new boolean[N][M];
        isVisited[startY][startX] = true;

        while (true) {
            Queue<Node> next = new LinkedList<>();

            while (!curr.isEmpty()) {
                Node now = curr.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || isVisited[ny][nx]) continue;

                    isVisited[ny][nx] = true;

                    if (map[ny][nx] == '0') {
                        curr.offer(new Node(ny, nx));
                    } else if (map[ny][nx] == '1') {
                        next.offer(new Node(ny, nx));
                    } else if (map[ny][nx] == '#') {
                        return jumps + 1;
                    }
                }
            }

            for (Node node : next) {
                map[node.y][node.x] = '0';
            }

            curr = next;
            jumps++;
        }
    }
}
