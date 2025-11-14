package graph.bfs;

import java.util.*;

public class Q1389 {

    static int N, M;
    static List<Integer>[] graph;
    static boolean[] isVisited;
    static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();
        M = sc.nextInt();
        graph = new List[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            graph[a].add(b);
            graph[b].add(a);
        }

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < N; i++) {
            int result = bfs(i);



            if (result < min) {
                min = result;
                minIndex = i;
            }
        }

        System.out.println(minIndex + 1);
    }

    /*
    5 5
    1 3
    1 4
    4 5
    4 3
    3 2

    1 -> 3, 4
    2 -> 3
    3 -> 1, 2, 4
    4 -> 1, 3, 5
    5 -> 4
     */

    static int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[N];
        Arrays.fill(dist, -1);
        queue.offer(n);
        dist[n] = 0;

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();

            for (Integer nextNode : graph[curr]) {
                if (dist[nextNode] != -1) {
                    continue;
                }
                dist[nextNode] = dist[curr] + 1;
                queue.offer(nextNode);
            }
        }

        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (i == n) {
                continue;
            }
            sum += dist[i];
        }

        return sum;
    }
}
