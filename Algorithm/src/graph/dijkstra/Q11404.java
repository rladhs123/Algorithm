package graph.dijkstra;

import java.util.*;

/**
 * 플로이드
 *
 * n(2 ≤ n ≤ 100)개의 도시가 있다.
 * 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다. 각 버스는 한 번 사용할 때 필요한 비용이 있다.
 * 모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.
 */
public class Q11404 {

    static int N, M;
    static List<Node>[] graph;
    static int[][] result;

    static class Node implements Comparable<Node>{
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            graph[from].add(new Node(to, weight));
        }

        result = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (result[i][j] == Integer.MAX_VALUE) {
                    sb.append(0).append(' ');
                } else {
                    sb.append(result[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void dijkstra(int from) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(from, 0));
        result[from][from] = 0;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (result[from][curr.to] < curr.weight) continue;

            for (Node node : graph[curr.to]) {
                if (result[from][node.to] > result[from][curr.to] + node.weight) {
                    result[from][node.to] = result[from][curr.to] + node.weight;
                    queue.offer(new Node(node.to, result[from][node.to]));
                }
            }
        }
    }

}
