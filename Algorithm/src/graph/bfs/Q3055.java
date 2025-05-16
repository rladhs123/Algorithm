package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 탈출
 *
 * 매 분마다 고슴도치는 현재 있는 칸과 인접한 네 칸 중 하나로 이동할 수 있다.
 * (위, 아래, 오른쪽, 왼쪽) 물도 매 분마다 비어있는 칸으로 확장한다.
 * 물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다. 물과 고슴도치는 돌을 통과할 수 없다.
 * 또, 고슴도치는 물로 차있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 이동할 수 없다.
 * 티떱숲의 지도가 주어졌을 때, 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간을 구하는 프로그램을 작성하시오.
 * 고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다.
 * 즉, 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다. 이동할 수 있으면 고슴도치가 물에 빠지기 때문이다.
 */
public class Q3055 {

    static int R, C;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int startY, startX;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    startY = i;
                    startX = j;
                }
            }
        }

        int result = bfs();

        if (result == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[R][C];
        int[][] result = new int[R][C];
        queue.offer(new Node(startY, startX));
        isVisited[startY][startX] = true;
        result[startY][startX] = 0;

        while (!queue.isEmpty()) {

            waterExpand();

            int size = queue.size();

            for (int k = 0; k < size; k++) {
                Node curr = queue.poll();

                if (map[curr.y][curr.x] == 'D') {
                    return result[curr.y][curr.x];
                }

                for (int i = 0; i < 4; i++) {
                    int nextY = curr.y + dy[i];
                    int nextX = curr.x + dx[i];

                    if (nextY >= 0 && nextX >= 0 && nextY < R && nextX < C) {
                        if (!isVisited[nextY][nextX] && map[nextY][nextX] == '.' || map[nextY][nextX] == 'D') {
                            queue.offer(new Node(nextY, nextX));
                            isVisited[nextY][nextX] = true;
                            result[nextY][nextX] = result[curr.y][curr.x] + 1;
                        }
                    }
                }
            }
        }

        return 0;
    }

    static void waterExpand() {
        int[][] water = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') {
                    for (int k = 0; k < 4; k++) {
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];

                        if (nextY >= 0 && nextX >= 0 && nextY < R && nextX < C) {
                            if (map[nextY][nextX] == '.') {
                                water[nextY][nextX] = 1;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (water[i][j] == 1) {
                    map[i][j] = '*';
                }
            }
        }
    }
}
