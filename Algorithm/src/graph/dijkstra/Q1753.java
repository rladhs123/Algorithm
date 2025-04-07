package graph.dijkstra;

import java.util.*;

/**
 * 최단경로
 *
 *방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오.
 * 단, 모든 간선의 가중치는 10 이하의 자연수이다.
 */
public class Q1753 {

    static int V, E, K, INF;
    static List<Node>[] graph;
    static int[] result;

    static class Node implements Comparable<Node>{
        int endNode, weight;

        public Node(int endNode, int weight) {
            this.endNode = endNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt();
        INF = Integer.MAX_VALUE;
        graph = new ArrayList[V + 1];
        result = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            result[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i < result.length; i++) {
            if (result[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }
    }

    static void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        boolean[] isVisited = new boolean[V + 1];
        queue.offer(new Node(start, 0));
        result[start] = 0;
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            for (Node nextNode : graph[currNode.endNode]) {
                if (result[nextNode.endNode] > result[currNode.endNode] + nextNode.weight) {
                    if (!isVisited[nextNode.endNode]) {
                        result[nextNode.endNode] = result[currNode.endNode] + nextNode.weight;
                        isVisited[currNode.endNode] = true;
                        queue.offer(new Node(nextNode.endNode, result[nextNode.endNode]));
                    }
                }
            }
        }
    }
}
