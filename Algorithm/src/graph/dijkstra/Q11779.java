package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11779 {

    static int N, M;
    static ArrayList<ArrayList<Node>> graph;
    static int start, end;

    static class Node implements Comparable<Node>{
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();
    }

    static void dijkstra() {
        Queue<Node> queue = new PriorityQueue<>();
        int[] isVisited = new int[N + 1];
        int[] prev = new int[N + 1];
        Arrays.fill(isVisited, 987654321);
        Arrays.fill(prev, -1);
        queue.offer(new Node(start, 0));
        isVisited[start] = 0;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.weight > isVisited[curr.to]) {
                continue;
            }

            for (Node next : graph.get(curr.to)) {
                if (isVisited[next.to] > isVisited[curr.to] + next.weight) {
                    isVisited[next.to] = isVisited[curr.to] + next.weight;
                    prev[next.to] = curr.to;
                    queue.offer(new Node(next.to, curr.weight + next.weight));
                }
            }
        }

        System.out.println(isVisited[end]);

        ArrayList<Integer> path = new ArrayList<>();
        int now = end;

        while (now != -1) {
            path.add(now);

            if (now == start) {
                break;
            }

            now = prev[now];
        }

        Collections.reverse(path);

        System.out.println(path.size());

        for (Integer i : path) {
            System.out.print(i + " ");
        }
    }
}
