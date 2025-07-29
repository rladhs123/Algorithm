package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Q20250730 {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] result;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int solution(int[][] maps) {
        int answer = bfs(maps);

        System.out.println(answer);
        return answer;
    }

    static int bfs(int[][] map) {
        int r = map.length;
        int c = map[0].length;
        result = new int[r][c];
        boolean[][] isVisited = new boolean[r][c];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        isVisited[0][0] = true;
        result[0][0] = 1;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.y == r - 1 && curr.x == c - 1) {
                return result[curr.y][curr.x];
            }

            for (int i = 0; i < 4; i++) {
                int nY = curr.y + dy[i];
                int nX = curr.x + dx[i];

                if (nY >= 0 && nX >= 0 && nY < r && nX < c) {
                    if (map[nY][nX] == 1 && !isVisited[nY][nX]) {
                        result[nY][nX] = result[curr.y][curr.x] + 1;
                        isVisited[nY][nX] = true;
                        queue.offer(new Node(nY, nX));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] map = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}};
        solution(map);
    }
}
