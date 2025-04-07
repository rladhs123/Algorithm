package graph.bfs;

import java.util.*;

/**
 * 연결 요소의 개수
 *
 * 방향 없는 그래프가 주어졌을 때,
 * 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 */
public class Q11724 {

    static int N;
    static int M;
    static List<ArrayList<Integer>> graph;
    static boolean[] isVisited;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        isVisited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                bfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            Integer currNode = queue.poll();

            for (int nextNode : graph.get(currNode)) {
                if (!isVisited[nextNode]) {
                    queue.offer(nextNode);
                    isVisited[nextNode] = true;
                }
            }
        }
    }
}
