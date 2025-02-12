package graph;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 단지 번호 붙이기
 *
 * 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
 * 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
 * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
 */
public class Q2667 {

    static int N;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<Integer> sector;
    static int count = 0;

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

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(Character.toString(input.charAt(j)));
            }
        }

        bfs();
        System.out.println(sector.size());
        Object[] array = sector.toArray();
        Arrays.sort(array);
        for (Object i : array) {
            System.out.println(i);
        }
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][N];
        sector = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    queue.offer(new Node(i, j));
                    isVisited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Node currNode = queue.poll();
                        count++;

                        for (int k = 0; k < 4; k++) {
                            int nextY = currNode.y + dy[k];
                            int nextX = currNode.x + dx[k];

                            if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < N) {
                                if (!isVisited[nextY][nextX] && map[nextY][nextX] == 1) {
                                    isVisited[nextY][nextX] = true;
                                    queue.offer(new Node(nextY, nextX));
                                }
                            }
                        }
                    }
                    sector.add(count);
                    count = 0;
                }
            }
        }
    }
}
