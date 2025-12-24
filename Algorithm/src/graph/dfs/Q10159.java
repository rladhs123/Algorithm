package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q10159 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        isVisited = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            isVisited[i][i] = true;
            dfs(i, i);
        }

        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (isVisited[i][j]) {
                    result[i]++;
                } else if (isVisited[j][i]) {
                    result[i]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(n - result[i]).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int start, int k) {
        for (Integer i : graph.get(k)) {
            if (!isVisited[start][i]) {
                isVisited[start][i] = true;
                dfs(start, i);
            }
        }
    }
}
