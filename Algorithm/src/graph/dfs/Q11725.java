package graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 트리의 부모 찾기
 *
 * 루트 없는 트리가 주어진다.
 * 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
 */
public class Q11725 {

    static int N;
    static List<List<Integer>> graph;
    static boolean[] isVisited;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new ArrayList<>();
        isVisited = new boolean[N + 1];
        result = new int[N + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        for (int i = 2; i < result.length; i++) {
            sb.append(result[i]).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int node) {
        isVisited[node] = true;

        for (Integer nextNode : graph.get(node)) {
            if (isVisited[nextNode]) {
                result[node] = nextNode;
            } else {
                dfs(nextNode);
            }
        }
    }
}
