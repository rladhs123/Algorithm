package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 도시와 비트코인
 *
 * 전날에 비해 비트코인의 시세가 백만원이나 오른 어느 아침, 진우는 거래소에 가서 비트코인을 매도하려고 한다.
 * 현재 비트코인의 시세가 점점 떨어지고 있기 때문에 진우는 최대한 빨리 거래소에 가야 한다.
 * 도시는 가로 N, 세로 M 크기의 격자 모양으로 이루어졌다. 진우는 북서쪽 끝에 있고 거래소는 남동쪽 끝에 있다.
 * 도시의 일부 구역은 공터 또는 도로라서 진우가 지나갈 수 있지만, 어떤 구역은 건물이 있어서 진우가 갈 수 없다.
 * 진우는 최대한 빨리 거래소에 가야 하므로, 동쪽(오른쪽) 또는 남쪽(아래쪽)으로만 이동하여 거래소로 도착할 수 있어야 한다.
 * 진우를 도와 거래소로 갈 수 있는지 구하는 프로그램을 작성하여라. 진우의 현재 위치가 거래소일 수 있다.
 */
public class Q31575 {

    static int N, M;
    static int[][] map;
    static int[] dy = {1, 0};
    static int[] dx = {0, 1};

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
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        if (bfs()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        boolean[][] isVisited = new boolean[M][N];
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.y == M - 1 && curr.x == N - 1) {
                return true;
            }

            for (int i = 0; i < 2; i++) {
                int nY = curr.y + dy[i];
                int nX = curr.x + dx[i];

                if (nY < M && nX < N) {
                    if (!isVisited[nY][nX] && map[nY][nX] == 1) {
                        isVisited[nY][nX] = true;
                        queue.offer(new Node(nY, nX));
                    }
                }
            }
        }

        return false;
    }
}
