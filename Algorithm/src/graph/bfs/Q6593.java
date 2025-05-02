package graph.bfs;

import java.util.*;

/**
 * 상범 빌딩
 *
 * 당신은 상범 빌딩에 갇히고 말았다. 여기서 탈출하는 가장 빠른 길은 무엇일까?
 * 상범 빌딩은 각 변의 길이가 1인 정육면체(단위 정육면체)로 이루어져있다.
 * 각 정육면체는 금으로 이루어져 있어 지나갈 수 없거나, 비어있어서 지나갈 수 있게 되어있다.
 * 당신은 각 칸에서 인접한 6개의 칸(동,서,남,북,상,하)으로 1분의 시간을 들여 이동할 수 있다.
 * 즉, 대각선으로 이동하는 것은 불가능하다. 그리고 상범 빌딩의 바깥면도 모두 금으로 막혀있어 출구를 통해서만 탈출할 수 있다.
 * 당신은 상범 빌딩을 탈출할 수 있을까? 만약 그렇다면 얼마나 걸릴까?
 */
public class Q6593 {

    static int L, R, C;
    static int[][][] building;
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int sz;
    static int sy;
    static int sx;
    static int ez;
    static int ey;
    static int ex;



    static class Node {
        int z, y, x;

        public Node(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            building = new int[L][R][C];

            sc.nextLine();
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = sc.next();
                    for (int k = 0; k < C; k++) {
                        char c = s.charAt(k);

                        if (c == 'S') {
                            sz = i;
                            sy = j;
                            sx = k;
                        } else if (c == 'E') {
                            ez = i;
                            ey = j;
                            ex = k;
                        }

                        if (c == '#') {
                            building[i][j][k] = 0;
                        } else {
                            building[i][j][k] = 1;
                        }
                    }
                    sc.nextLine();
                }
            }

            if (bfs()) {
                System.out.printf("Escaped in %d minute(s).\n", building[ez][ey][ex] - 1);
            } else {
                System.out.println("Trapped!");
            }
        }
    }

    static boolean bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sz, sy, sx));

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            if (currNode.z == ez && currNode.y == ey && currNode.x == ex) {
                return true;
            }

            for (int i = 0; i < 6; i++) {
                int nextZ = currNode.z + dz[i];
                int nextY = currNode.y + dy[i];
                int nextX = currNode.x + dx[i];

                if (nextZ >= 0 && nextY >= 0 && nextX >= 0 &&
                        nextZ < L && nextY < R && nextX < C) {
                    if (building[nextZ][nextY][nextX] == 1) {
                        building[nextZ][nextY][nextX] = building[currNode.z][currNode.y][currNode.x] + 1;
                        queue.offer(new Node(nextZ, nextY, nextX));
                    }
                }
            }
        }

        return false;
    }

}
