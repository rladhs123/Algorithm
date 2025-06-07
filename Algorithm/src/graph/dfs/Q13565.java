package graph.dfs;

import java.util.Scanner;

/**
 * 침투
 *
 * 인제대학교 생화학연구실에 재직중인 석교수는 전류가 침투(percolate) 할 수 있는 섬유 물질을 개발하고 있다.
 * 이 섬유 물질은 2차원 M × N 격자로 표현될 수 있다.
 * 편의상 2차원 격자의 위쪽을 바깥쪽(outer side), 아래쪽을 안쪽(inner side)라고 생각하기로 한다.
 * 또한 각 격자는 검은색 아니면 흰색인데, 검은색은 전류를 차단하는 물질임을 뜻하고 흰색은 전류가 통할 수 있는 물질임을 뜻한다.
 * 전류는 섬유 물질의 가장 바깥쪽 흰색 격자들에 공급되고, 이후에는 상하좌우로 인접한 흰색 격자들로 전달될 수 있다.
 * 김 교수가 개발한 섬유 물질을 나타내는 정보가 2차원 격자 형태로 주어질 때,
 * 바깥쪽에서 흘려 준 전류가 안쪽까지 침투될 수 있는지 아닌지를 판단하는 프로그램을 작성하시오.
 */
public class Q13565 {

    static int M, N;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] isVisited;
    static boolean check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        sc.nextLine();

        for (int i = 0; i < M; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(Character.toString(s.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            if (map[0][i] == 0) {
                isVisited = new boolean[M][N];
                dfs(0, i);
                if (check) {
                    break;
                }
            }
        }

        if (check) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void dfs(int y, int x) {
        isVisited[y][x] = true;

        if (y == M - 1) {
            check = true;
        }

        for (int i = 0; i < 4; i++) {
            int nY = y + dy[i];
            int nX = x + dx[i];

            if (nY >= 0 && nX >= 0 && nY < M && nX < N) {
                if (!isVisited[nY][nX] && map[nY][nX] == 0) {
                    dfs(nY, nX);
                }
            }
        }
    }
}
