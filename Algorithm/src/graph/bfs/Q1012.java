package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 유기농 배추
 *
 * 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 그 배추들 역시 해충으로부터 보호받을 수 있다.
 * 한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.
 * 한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어 놓았다.
 * 배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로
 * 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다.
 */
public class Q1012 {

    static int T;
    static int M;
    static int N;
    static int K;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] isVisited;
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

            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            map = new int[M][N];
            isVisited = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                int y = sc.nextInt();
                int x = sc.nextInt();
                map[y][x] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == 1 && !isVisited[j][k]) {
                        bfs(j, k);
                        count++;
                    }
                }
            }

            System.out.println(count);
            count = 0;

        }
    }

    static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(y, x));

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            isVisited[currNode.y][currNode.x] = true;

            for (int i = 0; i < 4; i++) {
                int nextY = currNode.y + dy[i];
                int nextX = currNode.x + dx[i];

                if (nextY >= 0 && nextX >= 0 && nextY < M && nextX < N) {
                    if (!isVisited[nextY][nextX] && map[nextY][nextX] == 1) {
                        queue.offer(new Node(nextY, nextX));
                        isVisited[nextY][nextX] = true;
                    }
                }
            }

        }
    }
}
