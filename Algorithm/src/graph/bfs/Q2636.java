package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 치즈
 * <p>
 * 입력으로 사각형 모양의 판의 크기와 한 조각의 치즈가 판 위에 주어졌을 때,
 * 공기 중에서 치즈가 모두 녹아 없어지는 데 걸리는 시간과 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수를 구하는 프로그램을 작성하시오.
 * (인접한 곳이 치즈가 아닌 부분이 있는 곳은 한 시간 뒤에 녹음)
 */
public class Q2636 {

    static int R, C;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] isVisited;
    static boolean isOver; // 하나라도 녹지 않는 치즈가 존재하면 거짓
    static boolean airCheck;
    static int time, count;

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
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        while (!isOver) {
            isVisited = new boolean[R][C];
            isOver = true;

            airCheck = true;
            bfs(0, 0);
            airCheck = false;

            isVisited = new boolean[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (!isVisited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 1) {
                        isOver = false;
                        break;
                    }
                }
            }
            remove();

            time++;
        }

        System.out.print(time + "\n" + count);
    }

    static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(y, x));
        isVisited[y][x] = true;
        if (airCheck) {
            map[y][x] = -1;
        }

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = curr.y + dy[i];
                int nextX = curr.x + dx[i];

                if (nextY >= 0 && nextX >= 0 && nextY < R && nextX < C) {
                    if (!isVisited[nextY][nextX]) {
                        if (airCheck) {
                            if (map[nextY][nextX] == 0 || map[nextY][nextX] == -1) {
                                queue.offer(new Node(nextY, nextX));
                                isVisited[nextY][nextX] = true;
                                map[nextY][nextX] = -1;
                            }
                        } else {
                            if (map[nextY][nextX] == 1) {
                                queue.offer(new Node(nextY, nextX));
                                isVisited[nextY][nextX] = true;
                            } else if (map[nextY][nextX] == -1) {
                                map[curr.y][curr.x] = 2;
                            }
                        }
                    }
                }
            }
        }


    }

    static void remove() {
        count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = -1;
                    if (isOver) {
                        count++;
                    }
                } else if (map[i][j] == 1) {
                    isOver = false;
                }
            }
        }
    }
}
