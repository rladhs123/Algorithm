package graph.bfs;

import java.util.*;

/**
 * 영역 구하기
 *
 * M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때,
 * K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지,
 * 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.
 */
public class Q2583 {

    static int M, N, K;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<Integer> area = new ArrayList<>();

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[M][N];
        isVisited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            int firstX = sc.nextInt();
            int firstY = sc.nextInt();
            int secondX = sc.nextInt();
            int secondY = sc.nextInt();

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (j >= firstY && j < secondY && k >= firstX && k < secondX) {
                        map[j][k] = -1;
                    }
                }
            }

        }
        int sector = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j] && map[i][j] != -1) {
                    bfs(i, j);
                    sector++;
                }
            }
        }
        Object[] array = area.toArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();

        sb.append(sector).append('\n');
        for (Object o : array) {
            sb.append(o).append(' ');
        }
        System.out.println(sb);
    }
    static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(y, x));
        isVisited[y][x] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            for (int i = 0; i < dy.length; i++) {
                int nextY = currNode.y + dy[i];
                int nextX = currNode.x + dx[i];

                if (nextY >= 0 && nextX >= 0 && nextY < M && nextX < N) {
                    if (!isVisited[nextY][nextX] && map[nextY][nextX] != -1) {
                        queue.offer(new Node(nextY, nextX));
                        isVisited[nextY][nextX] = true;
                        count++;
                    }
                }
            }
        }
        area.add(count);
    }
}
