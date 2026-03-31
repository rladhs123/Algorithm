package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q22865 {

    static int N, M;
    static int A, B, C;
    static List<ArrayList<Node>> graph;
    static int INF = 987_654_321;

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
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        int max = 0;
        int maxIndex = 0;

        int[] a = dijkstra(A);
        int[] b = dijkstra(B);
        int[] c = dijkstra(C);

        for (int i = 1; i <= N; i++) {
            if (i == A || i == B || i == C) {
                continue;
            }

            int currMin = Math.min(a[i], Math.min(b[i], c[i]));

            if (currMin > max) {
                max = currMin;
                maxIndex = i;
            }
        }

        System.out.println(maxIndex);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        Queue<Node> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (dist[curr.to] < curr.weight) {
                continue;
            }

            for (Node next : graph.get(curr.to)) {
                if (dist[next.to] > dist[curr.to] + next.weight) {
                    dist[next.to] = dist[curr.to] + next.weight;
                    queue.offer(new Node(next.to, dist[curr.to] + next.weight));
                }
            }
        }

        return dist;
    }
}