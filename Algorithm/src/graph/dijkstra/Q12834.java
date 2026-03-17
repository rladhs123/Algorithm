package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q12834 {

    static int N, V, E;
    static int A, B;
    static List<ArrayList<Node>> graph;
    static int[] arr;

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
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, l));
            graph.get(b).add(new Node(a, l));
        }

        int sum = 0;

        for (int i : arr) {
            sum += dijkstra(i);
        }

        System.out.println(sum);
    }

    static int dijkstra(int i) {
        Queue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[V + 1];
        Arrays.fill(dist, 987654321);
        dist[i] = 0;
        queue.offer(new Node(i, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (dist[curr.to] > curr.weight) {
                continue;
            }

            for (Node next : graph.get(curr.to)) {
                if (dist[next.to] > dist[curr.to] + next.weight) {
                    dist[next.to] = dist[curr.to] + next.weight;
                    queue.offer(new Node(next.to, dist[curr.to] + next.weight));
                }
            }
        }

        int distA = dist[A];
        int distB = dist[B];

        if (distA == 987654321) {
            distA = -1;
        }

        if (distB == 987654321) {
            distB = -1;
        }

        return distA + distB;
    }
}
