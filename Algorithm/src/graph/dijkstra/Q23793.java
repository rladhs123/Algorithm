package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q23793 {

    static int N, M;
    static int X, Y, Z;
    static List<ArrayList<Node>> graph;
    static int INF = 2_000_000_000;

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
        graph = new ArrayList<>();

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

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());

        int xy = dijkstra(X, Y, true);
        int yz = dijkstra(Y, Z, true);
        int a;

        if (xy == -1 || yz == -1) {
            a = -1;
        } else {
            a = xy + yz;
        }

        int b = dijkstra(X, Z, false);

        System.out.println(a + " " + b);
    }

    static int dijkstra(int start, int end, boolean b) {
        Queue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (dist[curr.to] < curr.weight) {
                continue;
            }

            for (Node next : graph.get(curr.to)) {
                if (!b && next.to == Y) {
                    continue;
                }

                if (dist[next.to] > dist[curr.to] + next.weight) {
                    dist[next.to] = dist[curr.to] + next.weight;
                    queue.offer(new Node(next.to, dist[curr.to] + next.weight));
                }
            }
        }

        if (dist[end] == INF) {
            return -1;
        } else {
            return dist[end];
        }
    }
}
