package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10282 {

    static int N, D, C;
    static ArrayList<ArrayList<Node>> graph;
    static int INF = 987654321;

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
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();

            for (int j = 0; j <= N; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < D; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph.get(b).add(new Node(a, s));
            }

            int[] result = dijkstra(C);

            sb.append(result[0]).append(' ').append(result[1]).append('\n');
        }

        System.out.print(sb);
    }

    static int[] dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        int[] isVisited = new int[N + 1];
        Arrays.fill(isVisited, INF);
        isVisited[start] = 0;

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

        int count = 0;
        int max = -1;

        for (int i = 1; i <= N; i++) {
            if (isVisited[i] == INF) {
                continue;
            }

            if (isVisited[i] > max) {
                max = isVisited[i];
            }

            count++;
        }

        return new int[]{count, max};
    }
}
