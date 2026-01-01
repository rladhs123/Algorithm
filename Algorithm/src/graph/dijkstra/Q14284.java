package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14284 {

    static int N, M;
    static ArrayList<ArrayList<Node>> graph;

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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int result = dijkstra(s, t);

        System.out.println(result);
    }

    static int dijkstra(int s, int t) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(s, 0));
        int[] isVisited = new int[N + 1];
        Arrays.fill(isVisited, 987654321);
        isVisited[s] = 0;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.weight > isVisited[curr.to]) {
                continue;
            }

            for (Node next : graph.get(curr.to)) {
                if (isVisited[next.to] > isVisited[curr.to] + next.weight) {
                    isVisited[next.to] = isVisited[curr.to] + next.weight;
                    queue.offer(new Node(next.to, curr.weight + next.weight));
                }
            }
        }

        return isVisited[t];
    }
}
