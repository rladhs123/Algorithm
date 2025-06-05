package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백조의 호수
 *
 * 두 마리의 백조가 호수에서 살고 있었다. 그렇지만 두 마리는 호수를 덮고 있는 빙판으로 만나지 못한다.
 * 호수는 행이 R개, 열이 C개인 직사각형 모양이다. 어떤 칸은 얼음으로 덮여있다.
 * 호수는 차례로 녹는데, 매일 물 공간과 접촉한 모든 빙판 공간은 녹는다.
 * 두 개의 공간이 접촉하려면 가로나 세로로 닿아 있는 것만 (대각선은 고려하지 않는다) 생각한다.
 * 백조는 오직 물 공간에서 세로나 가로로만(대각선은 제외한다) 움직일 수 있다.
 * 며칠이 지나야 백조들이 만날 수 있는 지 계산하는 프로그램을 작성하시오.
 */
public class Q3197 {

    static int R, C;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int startY, startX, endY, endX;
    static Queue<Node> swan = new LinkedList<>();
    static Queue<Node> nextSwan = new LinkedList<>();
    static Queue<Node> water = new LinkedList<>();
    static boolean[][] swanVisited;
    static boolean[][] waterVisited;

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
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        swanVisited = new boolean[R][C];
        waterVisited = new boolean[R][C];
        int n = 0;

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] != 'X') {
                    water.offer(new Node(i, j));
                    waterVisited[i][j] = true;
                }

                if (map[i][j] == 'L') {
                    if (n == 0) {
                        startY = i;
                        startX = j;
                        swan.offer(new Node(i, j));
                        swanVisited[i][j] = true;
                        n++;
                    } else {
                        endY = i;
                        endX = j;
                    }
                }
            }
        }

        int count = 0;

        while (true) {
            if (bfs()) break;
            remove();
            count++;
        }

        System.out.println(count);
    }

    static boolean bfs() {
        while (!swan.isEmpty()) {
            Node currNode = swan.poll();

            if (currNode.y == endY && currNode.x == endX) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nY = currNode.y + dy[i];
                int nX = currNode.x + dx[i];

                if (nY >= 0 && nX >= 0 && nY < R && nX < C) {
                    if (!swanVisited[nY][nX]) {
                        swanVisited[nY][nX] = true;
                        if (map[nY][nX] == 'X') {
                            nextSwan.offer(new Node(nY, nX));
                        } else {
                            swan.offer(new Node(nY, nX));
                        }
                    }
                }
            }
        }

        swan = nextSwan;
        nextSwan = new LinkedList<>();
        return false;
    }

    static void remove() {
        int size = water.size();
        while (size-- > 0) {
            Node currNode = water.poll();

            for (int i = 0; i < 4; i++) {
                int nY = currNode.y + dy[i];
                int nX = currNode.x + dx[i];

                if (nY >= 0 && nX >= 0 && nY < R && nX < C) {
                    if (!waterVisited[nY][nX] && map[nY][nX] == 'X') {
                        water.offer(new Node(nY, nX));
                        waterVisited[nY][nX] = true;
                        map[nY][nX] = '.';
                    }
                }
            }
        }
    }
}