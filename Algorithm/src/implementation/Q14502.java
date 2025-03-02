package implementation;

import java.util.*;
/**
 * 연구소
 *
 * 인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다.
 * 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.
 * 연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다.
 * 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.
 * 일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다.
 * 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
 * 연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.
 */
public class Q14502 {

    static int N, M; // 연구소 세로, 가로
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<Node> wallList = new ArrayList<>();
    static List<Node> virusList = new ArrayList<>();
    static int count;


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
        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    wallList.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    virusList.add(new Node(i, j));
                }
            }
        }

        //1. 벽 3개 세우기
        //2. 바이러스 확산
        //3. 안전 영역 계산
        int max = -1;
        for (int i = 0; i < wallList.size(); i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    Node node1 = wallList.get(i);
                    Node node2 = wallList.get(j);
                    Node node3 = wallList.get(k);

                    map[node1.y][node1.x] = 1;
                    map[node2.y][node2.x] = 1;
                    map[node3.y][node3.x] = 1;
                    max = Math.max(max, check());
                }
            }
        }
        System.out.println(max);
    }

    static int check() {

        count = 0;
        isVisited = new boolean[N][M];

        for (Node virusNode : virusList) {
            dfs(virusNode.y, virusNode.x, false);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j] && map[i][j] == 0) {
                    isVisited[i][j] = true;
                    count++;
                    dfs(i, j, true);
                }
            }
        }

        for (Node node : wallList) {
            map[node.y][node.x] = 0;
        }

        return count;
    }

    static void dfs(int y, int x, boolean isCount) {

        for (int i = 0; i < dy.length; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                if (map[nextY][nextX] == 0) {
                    if (!isCount) {
                        map[nextY][nextX] = 2;
                        dfs(nextY, nextX, false);
                    } else {
                        if (!isVisited[nextY][nextX]) {
                            count++;
                            isVisited[nextY][nextX] = true;
                            dfs(nextY, nextX, true);
                        }
                    }
                }
            }
        }
    }
}
