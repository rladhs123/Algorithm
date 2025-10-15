package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 영상처리
 *
 * 간단하지만 귀찮은 영상처리 과제가 주어졌다. 과제의 명세는 다음과 같다.
 *
 * 세로 길이가 N이고 가로 길이가 M인 화면은 총 N * M
 * (i, j)에 있는 픽셀은
 * R[i,j] (Red),
 * G[i,j] (Green),
 * B[i,j] (Blue) 3가지 색상의 의미를 담고 있다. 각 색상은 0이상 255이하인 값으로 표현 가능하다.
 * 모든 픽셀에서 세 가지 색상을 평균내어 경계값
 * T 보다 크거나 같으면 픽셀의 값을 255로, 작으면 0으로 바꿔서 새로운 화면으로 저장한다.
 * 새로 만들어진 화면에서 값이 255인 픽셀은 물체로 인식한다. 값이 255인 픽셀들이 상하좌우로 인접해있다면 이 픽셀들은 같은 물체로 인식된다.
 * 화면에서 물체가 총 몇 개 있는지 구하는 프로그램을 작성하시오.
 */
public class Q21938 {

    static int N, M, T;
    static int[][] screen;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] isVisited;

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
        screen = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3 * M; j++) {
                int input = sc.nextInt();

                screen[i][j / 3] += input;
            }
        }

        T = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (screen[i][j] / 3 >= T) {
                    screen[i][j] = 255;
                } else {
                    screen[i][j] = 0;
                }
            }
        }

        isVisited = new boolean[N][M];
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (screen[i][j] == 255 && !isVisited[i][j]) {
                    bfs(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(y, x));
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nY = curr.y + dy[i];
                int nX = curr.x + dx[i];

                if (nY >= 0 && nX >= 0 && nY < N && nX < M) {
                    if (screen[nY][nX] == 255 && !isVisited[nY][nX]) {
                        isVisited[nY][nX] = true;
                        queue.offer(new Node(nY, nX));
                    }
                }
            }
        }
    }
}
