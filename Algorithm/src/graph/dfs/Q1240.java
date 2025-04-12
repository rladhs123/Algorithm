package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 노드사이의 거리
 *
 * N개의 노드로 이루어진 트리가 주어지고 M개의 두 노드 쌍을 입력받을 때 두 노드 사이의 거리를 출력하라.
 */
public class Q1240 {

    static int N, M, distance;
    static List<Node>[] graph;
    static boolean[] isVisited;

    static class Node {
        int node, weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            isVisited = new boolean[N + 1];
            distance = 0;

            dfs(from, to);
            sb.append(distance).append('\n');
        }

        System.out.print(sb);
    }

    static boolean dfs(int node, int target) {

        if (node == target) {
            return true;
        }

        isVisited[node] = true;

        for (Node nextNode : graph[node]) {
            if (!isVisited[nextNode.node]) {
                distance += nextNode.weight;

                if (dfs(nextNode.node, target)) {
                    return true;
                }

                distance -= nextNode.weight;
            }
        }

        return false;
    }
}
