package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 불
 *
 * 상근이는 빈 공간과 벽으로 이루어진 건물에 갇혀있다. 건물의 일부에는 불이 났고, 상근이는 출구를 향해 뛰고 있다.
 * 매 초마다, 불은 동서남북 방향으로 인접한 빈 공간으로 퍼져나간다. 벽에는 불이 붙지 않는다.
 * 상근이는 동서남북 인접한 칸으로 이동할 수 있으며, 1초가 걸린다.
 * 상근이는 벽을 통과할 수 없고, 불이 옮겨진 칸 또는 이제 불이 붙으려는 칸으로 이동할 수 없다.
 * 상근이가 있는 칸에 불이 옮겨옴과 동시에 다른 칸으로 이동할 수 있다.
 * 빌딩의 지도가 주어졌을 때, 얼마나 빨리 빌딩을 탈출할 수 있는지 구하는 프로그램을 작성하시오.
 */
public class Q5427 {

    static int r, c;
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
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            c = sc.nextInt();
            r = sc.nextInt();
            sc.nextLine();
            map = new char[r][c];

            for (int j = 0; j < r; j++) {
                /*
                '.': 빈 공간
                '#': 벽
                '@': 상근이의 시작 위치
                '*': 불
                 */
                String s = sc.nextLine();
                for (int k = 0; k < c; k++) {
                    map[j][k] = s.charAt(k);
                    if (map[j][k] == '@') {
                        startY = j;
                        startX = k;
                        map[j][k] = '.';
                    }
                }
            }

            int x = bfs();

            if (x == 0) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(x);
            }
        }
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> fireQueue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*') {
                    fireQueue.offer(new Node(i, j));
                }
            }
        }
        boolean[][] isVisited = new boolean[r][c];
        queue.offer(new Node(startY, startX));
        isVisited[startY][startX] = true;
        int time = 0;

        while (!queue.isEmpty()) {
            //불 번지고 현재 불 큐에 삽입
            int fire = fireQueue.size();

            for (int i = 0; i < fire; i++) {
                Node f = fireQueue.poll();

                for (int j = 0; j < 4; j++) {
                    int nfY = f.y + dy[j];
                    int nfX = f.x + dx[j];

                    if (nfY >= 0 && nfX >= 0 && nfY < r && nfX < c) {
                        if (map[nfY][nfX] == '.') {
                            map[nfY][nfX] = '*';
                            fireQueue.offer(new Node(nfY, nfX));
                        }
                    }
                }
            }

            //사람 움직이고 현재 사람 큐에 삽입
            int man = queue.size();

            for (int i = 0; i < man; i++) {
                Node curr = queue.poll();

                if (curr.y == 0 || curr.y == r - 1 || curr.x == 0 || curr.x == c - 1) {
                    return time + 1;
                }

                for (int j = 0; j < 4; j++) {
                    int nY = curr.y + dy[j];
                    int nX = curr.x + dx[j];

                    if (nY >= 0 && nX >= 0 && nY < r && nX < c) {
                        if (map[nY][nX] == '.' && !isVisited[nY][nX]) {
                            isVisited[nY][nX] = true;
                            queue.offer(new Node(nY, nX));
                        }
                    }
                }
            }

            time++;
        }

        return 0;
    }
}
