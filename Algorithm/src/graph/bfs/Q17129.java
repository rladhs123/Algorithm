package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17129 {

    static int N, M;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int startY, startX;

    static class Node {
        int y, x, dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';

                if (map[i][j] == 2) {
                    startY = i;
                    startX = j;
                }
            }
        }

        int result = bfs(startY, startX);

        if (result == -1) {
            System.out.println("NIE");
        } else {
            System.out.println("TAK" + '\n' + result);
        }
    }

    static int bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(y, x, 0));
        boolean[][] isVisited = new boolean[N][M];
        isVisited[y][x] = true;


        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int currPosition = map[curr.y][curr.x];

            if (currPosition == 3 || currPosition == 4 || currPosition == 5) {
                return curr.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nY = curr.y + dy[i];
                int nX = curr.x + dx[i];

                if (nY >= 0 && nX >= 0 && nY < N && nX < M) {
                    if (!isVisited[nY][nX] && map[nY][nX] != 1) {
                        isVisited[nY][nX] = true;
                        queue.offer(new Node(nY, nX, curr.dist + 1));
                    }
                }
            }
        }

        return -1;
    }
}
