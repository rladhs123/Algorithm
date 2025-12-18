package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1504 {

    static int N, E;
    static List<Node>[] graph;
    static int V1, V2;
    static final int INF = 200_000_000;

    static class Node implements Comparable<Node> {
        int endNode, weight;

        public Node(int endNode, int weight) {
            this.endNode = endNode;
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
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());

        // v1 -> v2 == v2 -> v1
        int v1Tov2 = dijkstra(V1, V2);
        //route 1 (1 -> v1 -> v2 -> n)
        int route1 = dijkstra(1, V1) + v1Tov2 + dijkstra(V2, N);

        //route 2 (1 -> v2 -> v1 -> n)
        int route2 = dijkstra(1, V2) + v1Tov2 + dijkstra(V1, N);

        if (route1 >= INF && route2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(route1, route2));
        }
    }

    static int dijkstra(int start, int end) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        int[] result = new int[N + 1];
        Arrays.fill(result, INF);
        result[start] = 0;

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            if (result[currNode.endNode] < currNode.weight) {
                continue;
            }

            if (currNode.endNode == end) {
                return result[end];
            }

            for (Node nextNode : graph[currNode.endNode]) {
                if (result[nextNode.endNode] > result[currNode.endNode] + nextNode.weight) {
                    result[nextNode.endNode] = result[currNode.endNode] + nextNode.weight;
                    queue.offer(new Node(nextNode.endNode, result[nextNode.endNode]));
                }
            }
        }

        return result[end];
    }
}
