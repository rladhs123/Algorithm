package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 헌내기는 친구가 필요해
 *
 * 2020년에 입학한 헌내기 도연이가 있다. 도연이는 비대면 수업 때문에 학교에 가지 못해 학교에 아는 친구가 없었다.
 * 드디어 대면 수업을 하게 된 도연이는 어서 캠퍼스 내의 사람들과 친해지고 싶다.
 * 도연이가 다니는 대학의 캠퍼스는 N * M 크기이며 캠퍼스에서 이동하는 방법은 벽이 아닌 상하좌우로 이동하는 것이다.
 * 불쌍한 도연이를 위하여 캠퍼스에서 도연이가 만날 수 있는 사람의 수를 출력하는 프로그램을 작성해보자.
 */
public class Q21736 {

    static int N, M;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int startY, startX, count;

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
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'I') {
                    startY = i;
                    startX = j;
                }
            }
        }

        bfs();

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][M];
        queue.offer(new Node(startY, startX));
        isVisited[startY][startX] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (map[curr.y][curr.x] == 'P') {
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = curr.y + dy[i];
                int nextX = curr.x + dx[i];

                if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                    if (!isVisited[nextY][nextX] && map[nextY][nextX] != 'X') {
                        queue.offer(new Node(nextY, nextX));
                        isVisited[nextY][nextX] = true;
                    }
                }
            }
        }
    }
}
