package graph.bellmanford;

import java.util.*;

/**
 * 웜홀
 *
 * 때는 2020년, 백준이는 월드나라의 한 국민이다. 월드나라에는 N개의 지점이 있고 N개의 지점 사이에는 M개의 도로와 W개의 웜홀이 있다.
 * (단 도로는 방향이 없으며 웜홀은 방향이 있다.) 웜홀은 시작 위치에서 도착 위치로 가는 하나의 경로인데,
 * 특이하게도 도착을 하게 되면 시작을 하였을 때보다 시간이 뒤로 가게 된다. 웜홀 내에서는 시계가 거꾸로 간다고 생각하여도 좋다.
 * 시간 여행을 매우 좋아하는 백준이는 한 가지 궁금증에 빠졌다.
 * 한 지점에서 출발을 하여서 시간여행을 하기 시작하여 다시 출발을 하였던 위치로 돌아왔을 때,
 * 출발을 하였을 때보다 시간이 되돌아가 있는 경우가 있는지 없는지 궁금해졌다.
 * 여러분은 백준이를 도와 이런 일이 가능한지 불가능한지 구하는 프로그램을 작성하여라.
 */
public class Q1865 {

    static int TC, N, M, W;
    static List<Edge> graph;

    static class Edge {
        int s, e, t;

        public Edge(int s, int e, int t) {
            this.s = s;
            this.e = e;
            this.t = t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TC = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < TC; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            W = sc.nextInt();
            graph = new ArrayList<>();

            for (int j = 0; j < M; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int t = sc.nextInt();

                graph.add(new Edge(s, e, t));
                graph.add(new Edge(e, s, t));
            }

            for (int j = 0; j < W; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int t = sc.nextInt();

                graph.add(new Edge(s, e, -t));
            }

            if (!bellmanFord()) {
                sb.append("NO").append('\n');
            } else {
                sb.append("YES").append('\n');
            }
        }

        System.out.print(sb);
    }

    static boolean bellmanFord() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 0);

        for (int i = 1; i < N; i++) {
            for (Edge edge : graph) {
                if (dist[edge.e] > dist[edge.s] + edge.t) {
                    dist[edge.e] = dist[edge.s] + edge.t;
                }
            }
        }

        for (Edge edge : graph) {
            if (dist[edge.e] > dist[edge.s] + edge.t) {
                return true;
            }
        }

        return false;
    }
}
