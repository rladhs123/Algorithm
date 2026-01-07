package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18223 {

    static int V, E, P;
    static ArrayList<ArrayList<Node>> graph;
    static int[] isVisited;

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
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        int shortestPath = dijkstra(1, V);
        int savePath = dijkstra(1, P);
        int saveToEnd = dijkstra(P, V);

        if (savePath + saveToEnd <= shortestPath) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }

    static int dijkstra(int from, int to) {
        Queue<Node> queue = new PriorityQueue<>();
        isVisited = new int[V + 1];
        Arrays.fill(isVisited, 987654321);
        isVisited[from] = 0;
        queue.offer(new Node(from, 0));

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

        return isVisited[to];
    }
}
