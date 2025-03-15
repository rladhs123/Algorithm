package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 깊이 우선 탐색(dfs)
 */
public class Q24480 {

    static int N, M, R;
    static List<Integer>[] graph;
    static int[] visited;
    static int count = 1;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        graph = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i < graph.length; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        dfs(R);

        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = count;

        for (Integer nextNode : graph[node]) {
            if (visited[nextNode] == 0) {
                count++;
                dfs(nextNode);
            }
        }
    }
}
