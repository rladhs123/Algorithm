package graph.dijkstra;

import java.util.*;

/**
 * 녹색 옷 입은 애가 젤다지?
 *
 * 링크는 이 동굴의 반대편 출구, 제일 오른쪽 아래 칸인 [N-1][N-1]까지 이동해야 한다.
 * 동굴의 각 칸마다 도둑루피가 있는데, 이 칸을 지나면 해당 도둑루피의 크기만큼 소지금을 잃게 된다.
 * 링크는 잃는 금액을 최소로 하여 동굴 건너편까지 이동해야 하며, 한 번에 상하좌우 인접한 곳으로 1칸씩 이동할 수 있다.
 * 링크가 잃을 수밖에 없는 최소 금액은 얼마일까?
 */
public class Q4485 {

    static int N;
    static int[][] map;
    static int[][] result;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node implements Comparable<Node>{
        int y, x, cost;

        public Node(int y, int x, int cost) {
            this.y = y;
            this.x= x;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = 1;
        while (true) {
            N = sc.nextInt();

            if (N == 0) {
                break;
            }

            map = new int[N][N];
            result = new int[N][N];
            for (int[] r : result) {
                Arrays.fill(r, Integer.MAX_VALUE);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            result[0][0] = map[0][0];
            dijkstra();

            System.out.printf("Problem %d: %d\n", t, result[N - 1][N - 1]);
            t++;
        }
    }

    static void dijkstra() {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0, map[0][0]));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = curr.y + dy[i];
                int nextX = curr.x + dx[i];

                if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < N) {
                    if (curr.cost + map[nextY][nextX] < result[nextY][nextX]) {
                        result[nextY][nextX] = curr.cost + map[nextY][nextX];
                        queue.offer(new Node(nextY, nextX, curr.cost + map[nextY][nextX]));
                    }
                }
            }
        }
    }
}
