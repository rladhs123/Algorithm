package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14938 {

    static int N, M, R;
    static ArrayList<ArrayList<Node>> graph;
    static String[] items;
    static int result;

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
        R = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        items = br.readLine().split(" ");

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, l));
            graph.get(b).add(new Node(a, l));
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            result = 0;
            bfs(i);

            if (result > max) {
                max = result;
            }
        }

        System.out.println(max);
    }

    static void bfs(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 123_456_789);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node next : graph.get(curr.to)) {
                if (dist[next.to] > dist[curr.to] + next.weight) {
                    dist[next.to] = dist[curr.to] + next.weight;
                    queue.offer(new Node(next.to, curr.weight + next.weight));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= M) {
                result += Integer.parseInt(items[i - 1]);
            }
        }
    }
}
