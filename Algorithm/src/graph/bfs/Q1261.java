package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1261 {

    static int R, C;
    static int[][] map;
    static int[][] cost;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        cost = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j) - '0';
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();

        System.out.println(cost[R - 1][C - 1]);
    }

    static void bfs() {
        Deque<Node> queue = new ArrayDeque<>();
        queue.addFirst(new Node(0, 0));
        cost[0][0] = 0;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nY = curr.y + dy[i];
                int nX = curr.x + dx[i];

                if (nY >= 0 && nX >= 0 && nY < R && nX < C) {

                    if (map[nY][nX] == 1) {
                        if (cost[curr.y][curr.x] + 1 < cost[nY][nX]) {
                            cost[nY][nX] = cost[curr.y][curr.x] + 1;
                            queue.addLast(new Node(nY, nX));
                        }
                    } else {
                        if (cost[curr.y][curr.x] < cost[nY][nX]) {
                            cost[nY][nX] = cost[curr.y][curr.x];
                            queue.addFirst(new Node(nY, nX));
                        }
                    }
                }
            }
        }
    }
}
