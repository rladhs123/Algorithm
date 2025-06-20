package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16948 {

    static int N;
    static int[][] map;
    static int[] dy = {-2, -2, 0, 0, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -1, 1};
    static int startY, startX, endY, endX;

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
        map = new int[N][N];
        startY = sc.nextInt();
        startX = sc.nextInt();
        endY = sc.nextInt();
        endX = sc.nextInt();

        bfs();

        int result = map[endY][endX];

        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startY, startX));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.y == endY && curr.x == endX) {
                return;
            }

            for (int i = 0; i < dy.length; i++) {
                int nY = curr.y + dy[i];
                int nX = curr.x + dx[i];

                if (nY >= 0 && nX >= 0 && nY < N && nX < N) {
                    if (map[nY][nX] > map[curr.y][curr.x] + 1 || map[nY][nX] == 0) {
                        map[nY][nX] = map[curr.y][curr.x] + 1;
                        queue.offer(new Node(nY, nX));
                    }
                }
            }
        }
    }
}
