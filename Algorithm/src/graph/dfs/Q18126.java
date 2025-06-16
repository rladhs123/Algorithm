package graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q18126 {

    static List<Node>[] list;
    static boolean[] isVisited;
    static long max = 0;

    static class Node {
        int to;
        long distance;

        public Node(int to, long distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        list = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            long distance = sc.nextLong();

            list[from].add(new Node(to, distance));
            list[to].add(new Node(from, distance));
        }

        isVisited[1] = true;
        dfs(1, 0);

        System.out.println(max);
    }

    static void dfs(int from, long distance) {
        max = Math.max(max, distance);

        for (Node node : list[from]) {
            if (!isVisited[node.to]) {
                isVisited[node.to] = true;
                dfs(node.to, distance + node.distance);
            }
        }
    }
}
