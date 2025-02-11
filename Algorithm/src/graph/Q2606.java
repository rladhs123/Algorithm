package graph;

import java.util.*;

/**
 * 바이러스
 *
 * 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다.
 * 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
 */
public class Q2606 {

    static int N; //컴퓨터 수
    static int M; //연결된 컴퓨터 쌍

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        List<ArrayList<Integer>> graph = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a - 1).add(b - 1);
            graph.get(b - 1).add(a - 1);
        }

        int result = bfs(graph);
        System.out.println(result);
    }

    static int bfs(List<ArrayList<Integer>> graph) {
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[graph.size()];
        queue.offer(graph.get(0));
        isVisited[0] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> currNode = queue.poll();

            for (int i = 0; i < currNode.size(); i++) {
                int nextNode = currNode.get(i);
                if (!isVisited[nextNode]) {
                    queue.offer(graph.get(nextNode));
                    isVisited[nextNode] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
