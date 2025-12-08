package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1967 {

    static int N;
    static List<Edge>[] graph;
    static boolean[] isVisited;
    static int MAX = Integer.MIN_VALUE;
    static int endNode = 1;

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, w));
            graph[b].add(new Edge(a, w));
        }

        isVisited = new boolean[N + 1];
        isVisited[endNode] = true;
        dfs(endNode, 0);

        isVisited = new boolean[N + 1];
        isVisited[endNode] = true;
        MAX = Integer.MIN_VALUE;
        dfs(endNode, 0);

        System.out.println(MAX);
    }

    static void dfs(int curr, int dist) {
        if (dist > MAX) {
            MAX = dist;
            endNode = curr;
        }

        for (Edge edge : graph[curr]) {
            if (!isVisited[edge.to]) {
                isVisited[edge.to] = true;
                dfs(edge.to, dist + edge.weight);
            }
        }
    }
}
