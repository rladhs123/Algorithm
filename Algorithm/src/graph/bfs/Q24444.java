package graph.bfs;

import java.util.*;

/**
 * 너비 우선 탐색(bfs)
 */
public class Q24444 {

    static int N, M, R;
    static List<Integer>[] graph;
    static boolean[] isVisited;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        graph = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];
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
            Collections.sort(graph[i]);
        }

        bfs();

        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int num = 1;
        isVisited[R] = true;
        visited[R] = num;
        queue.offer(R);

        while (!queue.isEmpty()) {
            Integer currNode = queue.poll();

            for (int i = 0; i < graph[currNode].size(); i++) {
                if (!isVisited[graph[currNode].get(i)]) {
                    isVisited[graph[currNode].get(i)] = true;
                    visited[graph[currNode].get(i)] = ++num;
                    queue.offer(graph[currNode].get(i));
                }
            }
        }
    }
}
