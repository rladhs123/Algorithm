package graph.dfs;

import java.util.Scanner;

/**
 * 경로 찾기
 *
 * 가중치 없는 방향 그래프 G가 주어졌을 때,
 * 모든 정점 (i, j)에 대해서, i에서 j로 가는 길이가 양수인 경로가 있는지 없는지 구하는 프로그램을 작성하시오.
 */
public class Q11403 {

    static int N;
    static int[][] graph;
    static int[][] result;
    static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            isVisited = new boolean[N];
            dfs(i, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int start, int now) {

        for (int next = 0; next < N; next++) {
            if (graph[now][next] == 1 && !isVisited[next]) {
                isVisited[next] = true;
                result[start][next] = 1;
                dfs(start, next);
            }
        }
    }
}
