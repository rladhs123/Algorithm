package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1238 {

    static int N, M, X;
    static ArrayList<ArrayList<Node>> graph;
    static int[] result;

    static class Node implements Comparable<Node> {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        result = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        for (int i = 1; i <= N; i++) {
            int a = dijkstra(i, X);
            int b = dijkstra(X, i);

            result[i] = a + b;
        }

        int max = -1;

        for (int i = 1; i <= N; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }

        System.out.println(max);
    }

    static int dijkstra(int start, int end) {
        Queue<Node> queue = new PriorityQueue<>();
        int[] isVisited = new int[N + 1];
        Arrays.fill(isVisited, 987654321);
        queue.add(new Node(start, 0));
        isVisited[start] = 0;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.weight < isVisited[curr.to]) {
                continue;
            }

            for (Node next : graph.get(curr.to)) {
                if (isVisited[next.to] > isVisited[curr.to] + next.weight) {
                    isVisited[next.to] = isVisited[curr.to] + next.weight;
                    queue.offer(new Node(next.to, curr.weight + next.weight));
                }
            }
        }

        return isVisited[end];
    }
}
