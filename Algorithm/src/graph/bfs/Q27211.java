package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q27211 {

    static int N, M;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] isVisited;

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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !isVisited[i][j]) {
                    bfs(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(y, x));
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nY = curr.y + dy[i];
                int nX = curr.x + dx[i];

                if (nY < 0) {
                    nY = N + nY;
                } else if (nY >= N) {
                    nY %= N;
                }

                if (nX < 0) {
                    nX = M + nX;
                } else if (nX >= M) {
                    nX %= M;
                }

                if (!isVisited[nY][nX] && map[nY][nX] == 0) {
                    isVisited[nY][nX] = true;
                    queue.offer(new Node(nY, nX));
                }
            }
        }
    }
}
