package graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 나이트의 이동
 *
 * 체스판 위에 한 나이트가 놓여져 있다.
 * 나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다.
 * 나이트가 이동하려고 하는 칸이 주어진다.
 * 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?
 */
public class Q7562 {

    static int T;
    static int length;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int startY, startX;
    static int targetY, targetX;
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
        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            length = sc.nextInt();
            map = new int[length][length];
            isVisited = new boolean[length][length];
            startY = sc.nextInt();
            startX = sc.nextInt();
            targetY = sc.nextInt();
            targetX = sc.nextInt();
            count = 0;

            bfs();

            System.out.println(map[targetY][targetX]);
        }
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startY, startX));
        isVisited[startY][startX] = true;

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            for (int i = 0; i < dy.length; i++) {
                int nextY = currNode.y + dy[i];
                int nextX = currNode.x + dx[i];


                if (nextY >= 0 && nextX >= 0 && nextY < length && nextX < length) {
                    if (!isVisited[nextY][nextX]) {
                        queue.offer(new Node(nextY, nextX));
                        isVisited[nextY][nextX] = true;
                        map[nextY][nextX] = map[currNode.y][currNode.x] + 1;
                        if (nextY == targetY && nextX == targetX) {
                            return;
                        }
                    }
                }
            }
        }
    }
}
