package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 효율적인 해킹
 *
 * 해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다. 이 회사는 N개의 컴퓨터로 이루어져 있다.
 * 김지민은 귀찮기 때문에, 한 번의 해킹으로 여러 개의 컴퓨터를 해킹 할 수 있는 컴퓨터를 해킹하려고 한다.
 * 이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데,
 * A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다.
 * 이 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때,
 * 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.
 */
public class Q1325 {

    static int N, M;
    static List<Integer>[] graph;
    static int[] result;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        result = new int[N + 1];
        isVisited = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        for (int i = 1; i <= N ; i++) {
            isVisited = new boolean[N + 1];
            bfs(i);
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, result[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                sb.append(i).append(' ');
            }
        }

        System.out.print(sb);
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        isVisited[node] = true;

        while (!queue.isEmpty()) {
            Integer currNode = queue.poll();

            for (Integer nextNode : graph[currNode]) {
                if (!isVisited[nextNode]) {
                    queue.offer(nextNode);
                    isVisited[nextNode] = true;
                    result[nextNode]++;
                }
            }
        }
    }
}
