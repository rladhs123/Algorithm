package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13424 {

    static int N, M, K;
    static List<ArrayList<Node>> graph;
    static int[] minDist;

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
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();

            for (int j = 0; j <= N; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph.get(a).add(new Node(b, c));
                graph.get(b).add(new Node(a, c));
            }

            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            minDist = new int[N + 1];

            for (int j = 0; j < K; j++) {
                dijkstra(Integer.parseInt(st.nextToken()));
            }

            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 1; j <= N; j++) {
                if (minDist[j] < min) {
                    min = minDist[j];
                    minIndex = j;
                }
            }

            System.out.println(minIndex);
        }
    }

    static void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 987654321);
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

        for (int i = 1; i <= N; i++) {
            minDist[i] += dist[i];
        }
    }
}
