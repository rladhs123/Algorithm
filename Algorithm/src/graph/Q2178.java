package graph;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로찾기
 * N×M크기의 배열로 표현되는 미로가 있다.
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때,
 * (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
 * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 */
public class Q2178 {

    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node {
        int x, y;

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

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(Character.toString(input.charAt(j)));
            }
        }

        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }
    //y = row, x = colum
    public static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][M];
        queue.offer(new Node(y, x));
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            int currX = currNode.x;
            int currY = currNode.y;
            if (currY == N - 1 && currX == M - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextY < N && nextX < M) {
                    if (!isVisited[nextY][nextX] && map[nextY][nextX] == 1) {
                        queue.offer(new Node(nextY, nextX));
                        isVisited[nextY][nextX] = true;
                        map[nextY][nextX] = map[currY][currX] + 1;
                    }
                }
            }
        }
    }
}
