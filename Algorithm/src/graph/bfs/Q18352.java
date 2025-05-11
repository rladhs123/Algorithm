package graph.bfs;

import java.util.*;

/**
 * 특정 거리의 도시 찾기
 *
 * 어떤 나라에는 1번부터 N번까지의 도시와 M개의 단방향 도로가 존재한다. 모든 도로의 거리는 1이다.
 * 이 때 특정한 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중에서,
 * 최단 거리가 정확히 K인 모든 도시들의 번호를 출력하는 프로그램을 작성하시오.
 * 또한 출발 도시 X에서 출발 도시 X로 가는 최단 거리는 항상 0이라고 가정한다.
 */
public class Q18352 {

    static int N, M, K, X;
    static List<Integer>[] graph;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        graph = new List[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        boolean isSame = false;

        for (int i = 1; i <= N; i++) {
            if (result[i] == K) {
                sb.append(i + "\n");
                isSame = true;
            }

        }

        if (isSame) {
            System.out.print(sb);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[N + 1];
        queue.offer(X);
        isVisited[X] = true;

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();

            for (Integer next : graph[curr]) {
                if (!isVisited[next]) {
                    queue.offer(next);
                    isVisited[next] = true;
                    result[next] = result[curr] + 1;
                }
            }
        }
    }
}
