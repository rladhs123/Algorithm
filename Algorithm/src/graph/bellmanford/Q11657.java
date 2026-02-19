package graph.bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 타임머신
 *
 * N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 버스가 M개 있다.
 * 각 버스는 A, B, C로 나타낼 수 있는데, A는 시작도시, B는 도착도시, C는 버스를 타고 이동하는데 걸리는 시간이다.
 * 시간 C가 양수가 아닌 경우가 있다. C = 0인 경우는 순간 이동을 하는 경우, C < 0인 경우는 타임머신으로 시간을 되돌아가는 경우이다.
 * 1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 작성하시오.
 */
public class Q11657 {

    static int N, M;
    static List<Edge> edges;
    static long[] dist;
    static long INF = Long.MAX_VALUE / 2;

    static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, weight));
        }

        StringBuilder sb = new StringBuilder();

        if (bellmanFord()) {
            sb.append(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append(-1);
                } else {
                    sb.append(dist[i]);
                }

                sb.append('\n');
            }
        }

        System.out.print(sb);
    }

    static boolean bellmanFord() {
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i < N; i++) {
            for (Edge edge : edges) {
                if (dist[edge.from] == INF) {
                    continue;
                }

                if (dist[edge.to] > dist[edge.from] + edge.weight) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                }
            }
        }

        for (Edge edge : edges) {
            if (dist[edge.from] == INF) {
                continue;
            }

            if (dist[edge.to] > dist[edge.from] + edge.weight) {
                return true;
            }
        }

        return false;
    }
}
