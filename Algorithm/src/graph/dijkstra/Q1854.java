package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1854 {

    static int N, M, K;
    static ArrayList<ArrayList<Node>> graph;
    static StringBuilder sb = new StringBuilder();

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
        K = Integer.parseInt(st.nextToken());
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
        }

        dijkstra();

        System.out.print(sb);
    }

    static void dijkstra() {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1, 0));

        PriorityQueue<Integer>[] candidates = new PriorityQueue[N + 1];

        for (int i = 1; i <= N; i++) {
            candidates[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        candidates[1].offer(0);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (candidates[curr.to].size() == K && candidates[curr.to].peek() < curr.weight) {
                continue;
            }

            for (Node next : graph.get(curr.to)) {
                if (candidates[next.to].size() < K) {
                    candidates[next.to].offer(curr.weight + next.weight);
                    queue.offer(new Node(next.to, curr.weight + next.weight));
                } else if (candidates[next.to].peek() > curr.weight + next.weight) {
                    candidates[next.to].poll();
                    candidates[next.to].offer(curr.weight + next.weight);
                    queue.offer(new Node(next.to, curr.weight + next.weight));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (candidates[i].size() < K) {
                sb.append(-1);
            } else {
                sb.append(candidates[i].peek());
            }
            sb.append('\n');
        }
    }
}
