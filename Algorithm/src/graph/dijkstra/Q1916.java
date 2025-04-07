package graph.dijkstra;

import java.util.*;

/**
 * 최소비용 구하기
 * <p>
 * N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다.
 * 우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다.
 * A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라.
 * 도시의 번호는 1부터 N까지이다.
 */
public class Q1916 {

    static int N, M, start, target;
    static List<Node>[] graph;
    static int[] result;

    static class Node implements Comparable<Node> {
        int endNode;
        int weight;

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
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new ArrayList[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Node(v, w));
        }

        start = sc.nextInt();
        target = sc.nextInt();

        dijkstra();

        System.out.println(result[target]);
    }

    static void dijkstra() {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        result[start] = 0;

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            if (result[currNode.endNode] < currNode.weight) continue;

            for (Node nextNode : graph[currNode.endNode]) {
                if (result[nextNode.endNode] > result[currNode.endNode] + nextNode.weight) {
                    result[nextNode.endNode] = result[currNode.endNode] + nextNode.weight;
                    queue.offer(new Node(nextNode.endNode, result[nextNode.endNode]));
                }
            }
        }
    }
}
